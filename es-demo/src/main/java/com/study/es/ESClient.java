package com.study.es;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.logging.log4j.util.Strings;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.unit.TimeValue;

import com.google.common.base.Splitter;

@Slf4j
public class ESClient {
    private final String clusterNodes;
    private final String protocol;
    private final String trustStorePath;
    private final String getTrustStorePass;
    private final String user;
    private final String password;
    private final ReentrantLock connectLock = new ReentrantLock();

    protected volatile RestHighLevelClient client;

    public ESClient(String clusterNodes, String protocol, String trustStorePath, String getTrustStorePass, String user, String password) {
        this.clusterNodes = clusterNodes;
        this.protocol = protocol;
        this.trustStorePath = trustStorePath;
        this.getTrustStorePass = getTrustStorePass;
        this.user = user;
        this.password = password;
    }

    public void connect() throws Exception {
        connectLock.lock();
        try {
            List<HttpHost> hosts = parseClusterNodes(protocol, clusterNodes);
            client = createClient(hosts);
        } finally {
            connectLock.unlock();
        }
    }

    public void shutdown() throws IOException {
        client.close();
    }

    private List<HttpHost> parseClusterNodes(String protocol, String clusterNodes) {
        List<HttpHost> httpHosts = new ArrayList<>();
        List<String> nodesSplit = Splitter.on(",").omitEmptyStrings().splitToList(clusterNodes);
        for (String node : nodesSplit) {
            String host = node.split(":")[0];
            String port = node.split(":")[1];
            httpHosts.add(new HttpHost(host, Integer.parseInt(port), protocol));
        }
        return httpHosts;
    }

    protected RestHighLevelClient createClient(List<HttpHost> pairsList) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, KeyManagementException {
        RestClientBuilder builder;
        if (Strings.isNotBlank(user) && Strings.isNotBlank(password)) {
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, password));
            if (Strings.isEmpty(trustStorePath)) {
                builder = RestClient.builder(pairsList.toArray(new HttpHost[0]))
                        .setHttpClientConfigCallback(httpAsyncClientBuilder ->
                                httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider));

            } else {
                KeyStore truststore = KeyStore.getInstance("jks");
                try (InputStream is = Files.newInputStream(Paths.get(trustStorePath))) {
                    truststore.load(is, trustStorePath.toCharArray());
                }
                SSLContextBuilder sslBuilder = SSLContexts.custom().loadTrustMaterial(truststore, null);
                final SSLContext sslContext = sslBuilder.build();
                builder = RestClient.builder(pairsList.toArray(new HttpHost[0]))
                        .setHttpClientConfigCallback(httpAsyncClientBuilder ->
                                httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setSSLContext(sslContext));
            }
        } else {
            builder = RestClient.builder(pairsList.toArray(new HttpHost[0]));
        }
        return new RestHighLevelClient(builder);
    }

    public boolean createIndex(String indexName) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        return response.isAcknowledged();
    }

    public boolean createIndex(String indexName, Map<String, Object> settings,
            Map<String, Object> mapping) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings(settings);
        request.mapping(mapping);
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        return response.isAcknowledged();
    }

    protected BulkProcessor.Listener createBulkListener() {
        return new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long executionId, BulkRequest request) {
                int numberOfActions = request.numberOfActions();
                log.debug("Executing bulk [{}] with {} requests", executionId, numberOfActions);
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                if (response.hasFailures()) {
                    log.warn("Bulk [{}] executed with failures:[{}]", executionId, response.buildFailureMessage());
                } else {
                    log.info(
                            "Bulk execution id [{}] completed in {} milliseconds, size: {}", executionId, response.getTook()
                                    .getMillis(),
                            request
                                    .requests()
                                    .size()
                    );
                }
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                log.error("Failed to execute bulk", failure);
            }
        };
    }

    public BulkProcessor createBulkProcessor(int bulkActions, int flushInterval, int concurrentRequests) {
        BulkProcessor.Listener listener = createBulkListener();

        return BulkProcessor.builder(
                (bulkRequest, bulkResponseActionListener) -> client.bulkAsync(bulkRequest, RequestOptions.DEFAULT,
                        bulkResponseActionListener
                ), listener)
                .setBulkActions(bulkActions)
                .setFlushInterval(TimeValue.timeValueSeconds(flushInterval))
                .setConcurrentRequests(concurrentRequests)
                .setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))
                .build();
    }
}
