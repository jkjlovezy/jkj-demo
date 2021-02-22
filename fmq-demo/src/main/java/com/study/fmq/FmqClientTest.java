package com.study.fmq;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Iterator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.focustech.fmq.clients.consumer.config.ConsumerConfig;
import com.focustech.fmq.clients.consumer.impl.FMQConsumer;
import com.focustech.kafka.clients.consumer.ConsumerRecord;
import com.focustech.kafka.clients.consumer.ConsumerRecords;
import com.focustech.kafka.clients.consumer.OffsetResetStrategy;
import com.focustech.kafka.common.utils.Bytes;
import com.focustech.silk.gateway.biz.nodedata.WrapperGatewayMessage;

@Slf4j
public class FmqClientTest {
    public static void main(String[] args) {
        String currentSite = "LOCAL";
        String bootstrapServers = "192.168.53.26:9092,192.168.53.27:9092,192.168.53.28:9092";
        String groupId = "jkj-fmq-test3";
        ConsumerConfig config = new ConsumerConfig(currentSite,bootstrapServers,groupId);
        config.setAutoOffsetReset(OffsetResetStrategy.EARLIEST);
        FMQConsumer consumer = new FMQConsumer(config);

        consumer.subscribe("crov_lg_label_print_local");
        while (true) {
            try {
                log.debug("consume topic begin");
                ConsumerRecords<String, String> consumerRecords = consumer.pollDeserialized(Duration.ofMillis(500L).toMillis(), String.class);
                if (!consumerRecords.isEmpty()) {
                    Iterator<ConsumerRecord<String, String>> iterator = consumerRecords.iterator();
                    while (iterator.hasNext()) {
                        ConsumerRecord<String, String> record = iterator.next();
                        log.info(JSONObject.toJSONString(record));
                        log.info(JSON.toJSONString(record));
                        log.info(iterator.next().value());
                    }
                    consumer.commitSync();
                }
            } catch (Exception e) {
                log.error("consume topic error:", e);
            }
        }

        /*consumer.subscribe("gateway_metainfo_update_phx");
        while (true) {
            try {
                log.debug("consume topic begin");
                ConsumerRecords<String, WrapperGatewayMessage> consumerRecords = consumer.pollDeserialized(Duration.ofMillis(500L).toMillis(), WrapperGatewayMessage.class);
                if (!consumerRecords.isEmpty()) {
                    Iterator<ConsumerRecord<String, WrapperGatewayMessage>> iterator = consumerRecords.iterator();
                    while (iterator.hasNext()) {
                        log.info(iterator.next().value().toString());
                    }
                    consumer.commitSync();
                }
            } catch (Exception e) {
                log.error("consume topic error:", e);
            }
        }*/
    }
}
