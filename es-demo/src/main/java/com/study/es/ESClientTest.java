package com.study.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

import com.alibaba.fastjson.JSON;

public class ESClientTest {
    public static void main(String[] args) throws Exception {
        ESClient esClient = new ESClient("192.168.52.56:9200", "http", null, null, null, null);
        esClient.connect();
        BulkProcessor bulkProcessor = esClient.createBulkProcessor(2000, 10, 2);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            if (i % 1000 == 0) {
                System.out.println("processing " + i);
            }
            bulkProcessor.add(new IndexRequest("jkj-product4").id(buildSkuCode(i))
                    .source(JSON.toJSONString(buildProduct(i)), XContentType.JSON));
        }
        bulkProcessor.flush();
        System.out.println("over" + (System.currentTimeMillis() - start));

        Thread.sleep(30 * 1000L);
        esClient.shutdown();
    }

    private static String buildSkuCode(int loop) {
        return "sku" + loop;
    }

    private static Product buildProduct(int loop) {
        Product product = new Product();
        product.setSkuCode(buildSkuCode(loop));
        product.setPrice(getRandom(30, 200));
        product.setMonthlyStat(new ArrayList<>());
        for (int i = 0; i < 6; i++) {
            product.getMonthlyStat().add(new MonthlyStat(202101 + i, getRandom(20, 500), getPrice(1000, 5000)));
        }
        return product;
    }

    private static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    private static BigDecimal getPrice(int min, int max) {
        Random random = new Random();
        int intVal = random.nextInt(max) % (max - min + 1) + min;
        int decimalVal = getRandom(0, 100) / 100;
        return new BigDecimal(intVal).add(new BigDecimal(getRandom(0, 100)).divide(new BigDecimal(100)));
    }

    @Data
    static class Product {
        private String skuCode;
        private int price;
        private List<MonthlyStat> monthlyStat;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class MonthlyStat {
        private int month;
        private int salesCount;
        private BigDecimal salesAmount;
    }
}
