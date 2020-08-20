package com.study.util.fmq;

import org.apache.skywalking.apm.agent.core.fmq.FmqProducerManager;
import org.apache.skywalking.apm.agent.core.fmq.FmqReporterPluginConfig;
import org.apache.skywalking.apm.agent.core.fmq.MyFmqProducer;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.config.ProducerConfig;
import org.apache.skywalking.apm.dependencies.com.focustech.fmq.clients.producer.impl.FMQProducer;

public class MyFmqProducerTest {
    public static void main(String[] args) {
        ProducerConfig producerConfig = new ProducerConfig(FmqReporterPluginConfig.Plugin.Fmq.BOOTSTRAP_SERVERS, new FmqProducerManager.FmqBytesSerializer());
        FMQProducer  producer = new MyFmqProducer(producerConfig);
    }
}
