package com.study.util.fmq;

import static com.focustech.kafka.clients.producer.ProducerConfig.ACKS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.CLIENT_ID_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.MAX_BLOCK_MS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION;
import static com.focustech.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.apache.skywalking.apm.agent.core.fmq.FmqReporterPluginConfig;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.ProducerMessage;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.SendResult;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.impl.FMQProducer;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.clients.CommonClientConfigs;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.clients.admin.AdminClient;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.clients.admin.DescribeTopicsResult;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.common.utils.Bytes;
import org.apache.skywalking.apm.dependencies.com.focustech.serialization.AbstractSerializer;

import com.focustech.kafka.clients.producer.KafkaProducer;
import com.focustech.kafka.clients.producer.ProducerConfig;
import com.focustech.kafka.common.serialization.ByteArraySerializer;
import com.focustech.kafka.common.serialization.Serializer;
import com.focustech.kafka.common.serialization.StringSerializer;
import com.focustech.kafka.common.utils.Utils;

public class FmqTest {
    public static void main(String[] args) throws Exception {

        Class.forName("org.apache.skywalking.apm.dependencies.com.focustech.kafka.common.serialization.StringSerializer", true, Utils.getContextOrKafkaClassLoader());

//        ProducerConfig producerConfig = new ProducerConfig("192.168.53.26:9092,192.168.53.27:9092,192.168.53.28:9092", new FmqBytesSerializer());
//        FMQProducer producer = new FMQProducer(producerConfig);
//        SendResult result = producer.sendSync(FmqReporterPluginConfig.Plugin.Fmq.TOPIC_METRICS,new ProducerMessage(com.focustech.kafka.common.utils.Bytes.wrap("test".getBytes())));
//        System.out.println(result.isSuccessful());

        Arrays.stream(ProducerConfig.class.getDeclaredConstructors()).forEach(constructor -> {
            System.out.println(constructor.getParameters());
        });

        com.focustech.kafka.clients.producer.ProducerConfig config = null;
        Properties kafkaConfig = new Properties();
//        kafkaConfig.setProperty(KEY_SERIALIZER_CLASS_CONFIG, "com.focustech.kafka.common.serialization.StringSerializer");
//        kafkaConfig.setProperty(VALUE_SERIALIZER_CLASS_CONFIG, "com.focustech.kafka.common.serialization.ByteArraySerializer");

        kafkaConfig.setProperty(BOOTSTRAP_SERVERS_CONFIG, "192.168.53.26:9092,192.168.53.27:9092,192.168.53.28:9092");
        kafkaConfig.setProperty(CLIENT_ID_CONFIG, "client1");
        kafkaConfig.setProperty(MAX_BLOCK_MS_CONFIG, "1000");
        kafkaConfig.setProperty(ACKS_CONFIG, "1");
        kafkaConfig.setProperty(MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,"20");
        try {
            Constructor configConstructor = ProducerConfig.class.getDeclaredConstructor(Map.class);
            configConstructor.setAccessible(true);
            config = (com.focustech.kafka.clients.producer.ProducerConfig) configConstructor.newInstance(com.focustech.kafka.clients.producer.ProducerConfig.addSerializerToConfig(kafkaConfig, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            Constructor c = KafkaProducer.class.getDeclaredConstructor(ProducerConfig.class, Serializer.class, Serializer.class);
            c.setAccessible(true);
            KafkaProducer<String, byte[]> kafkaProducer = (KafkaProducer<String, byte[]>) c.newInstance(config, new StringSerializer(), new ByteArraySerializer());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static class FmqBytesSerializer extends AbstractSerializer {

        @Override
        protected byte[] doSerialize(Object data) throws Throwable {
            if (data instanceof Bytes) {
                return ((Bytes) data).get();
            }
            return new byte[0];
        }
    }
}
