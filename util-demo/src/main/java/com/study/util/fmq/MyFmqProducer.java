package com.study.util.fmq;

import static com.focustech.kafka.clients.producer.ProducerConfig.ACKS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.CLIENT_ID_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.MAX_BLOCK_MS_CONFIG;
import static com.focustech.kafka.clients.producer.ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Properties;


import org.apache.skywalking.apm.agent.core.fmq.FmqReporterPluginConfig;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.config.ProduceAckType;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.impl.FMQProducer;

import org.apache.skywalking.apm.dependencies.com.focustech.kafka.clients.producer.KafkaProducer;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.clients.producer.ProducerConfig;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.common.serialization.ByteArraySerializer;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.common.serialization.Serializer;
import org.apache.skywalking.apm.dependencies.com.focustech.kafka.common.serialization.StringSerializer;

public class MyFmqProducer extends FMQProducer {
    public MyFmqProducer(org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.config.ProducerConfig config) {
        super(config);
    }

    protected void convertAndSaveConfig(org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.config.ProducerConfig config) {
        this.fmqConfig = config;
        if (config.getMoreConfig() != null) {
            kafkaConfig = config.getMoreConfig();
        } else {
            kafkaConfig = new Properties();
            config.setMoreConfig(kafkaConfig);
        }

        this.serializer = config.getSerializer();
        if (serializer == null) {
            throw new IllegalArgumentException("serializer must not be null!");
        }

//        kafkaConfig.setProperty(KEY_SERIALIZER_CLASS_CONFIG, "com.focustech.kafka.common.serialization.StringSerializer");
//        kafkaConfig.setProperty(VALUE_SERIALIZER_CLASS_CONFIG, "com.focustech.kafka.common.serialization.ByteArraySerializer");

        kafkaConfig.setProperty(BOOTSTRAP_SERVERS_CONFIG, config.getServerAddrs());
        kafkaConfig.setProperty(CLIENT_ID_CONFIG, config.getClientId());
        kafkaConfig.setProperty(MAX_BLOCK_MS_CONFIG, String.valueOf(config.getBlockTimeMs()));
        kafkaConfig.setProperty(ACKS_CONFIG, config.getAck().kafkaAck());
        kafkaConfig.setProperty(MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, String.valueOf(config.getMaxInFlightRequestsPerConnection()));
        if (config.isIdempotent()) {
            if (config.getMaxInFlightRequestsPerConnection() <= 0 || config.getMaxInFlightRequestsPerConnection() > 5) {
                throw new IllegalArgumentException("maxInFlightRequestsPerConnection must in (0,5]");
            }
            kafkaConfig.setProperty(ENABLE_IDEMPOTENCE_CONFIG, "true");
            kafkaConfig.setProperty(ACKS_CONFIG, ProduceAckType.ALL.kafkaAck());
        }

    }

    protected void buildKafkaProducer() {
        log.info("build " + this.getClass().getSimpleName() + " with " + fmqConfig);
        ProducerConfig config = null;
        try {
            Constructor configConstructor = ProducerConfig.class.getDeclaredConstructor(Map.class);
            configConstructor.setAccessible(true);
            config = (ProducerConfig) configConstructor.newInstance(ProducerConfig.addSerializerToConfig(kafkaConfig, null, null));
        } catch (Exception e) {
            throw new IllegalArgumentException("ProducerConfig constructor newInstance  error!");
        }
        try{
            Constructor c = KafkaProducer.class.getDeclaredConstructor(ProducerConfig.class, Serializer.class, Serializer.class);
            c.setAccessible(true);
            kafkaProducer = (KafkaProducer<String, byte[]>) c.newInstance(config, new StringSerializer(), new ByteArraySerializer());
        } catch (Exception e) {
            throw new IllegalArgumentException("KafkaProducer constructor newnewInstance error!");
        }
    }

}
