package com.study.fmq;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.focustech.fmq.clients.consumer.config.ConsumerConfig;
import com.focustech.fmq.clients.consumer.impl.FMQConsumer;
import com.focustech.kafka.clients.consumer.ConsumerRecord;
import com.focustech.kafka.clients.consumer.ConsumerRecords;
import com.focustech.kafka.clients.consumer.OffsetResetStrategy;
import com.focustech.kafka.common.PartitionInfo;
import com.focustech.kafka.common.utils.Bytes;
import com.focustech.silk.gateway.biz.nodedata.WrapperGatewayMessage;

@Slf4j
public class FmqClientTest {
    public static void main(String[] args) {
        testActive("192.168.63.89:9092,192.168.63.90:9092,192.168.63.91:9092");
        //testActive("192.168.63.61:9092,192.168.63.62:9092,192.168.63.64:9092");
    }

    static void testActive(String bootstrapServers){
        String currentSite = "PHX";
        String groupId = "jkj-fmq-test11";
        ConsumerConfig config = new ConsumerConfig(currentSite,bootstrapServers,groupId);
        config.setAutoOffsetReset(OffsetResetStrategy.EARLIEST);
        try(FMQConsumer consumer = new FMQConsumer(config)){
            Map<String, List<PartitionInfo>> map =  consumer.listTopics();
            System.out.println("-----------------------------");
            map.keySet().stream().filter(topic->topic.startsWith("skywalking")).forEach(System.out::println);
            System.out.println(map);
//            consumer.subscribe("skywalking_segments_phx2");
//            //while (true) {
//                try {
//                    log.debug("consume topic begin");
//                    ConsumerRecords<String, Bytes> consumerRecords = consumer.pollDeserialized(Duration.ofMillis(500L).toMillis(), Bytes.class);
//                    if (!consumerRecords.isEmpty()) {
//                        Iterator<ConsumerRecord<String, Bytes>> iterator = consumerRecords.iterator();
//                        while (iterator.hasNext()) {
//                            ConsumerRecord<String, Bytes> record = iterator.next();
//                            System.out.println(record);
//                        }
//                        consumer.commitSync();
//                    }
//                } catch (Exception e) {
//                    log.error("consume topic error:", e);
//                }
//            //}
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    static void test(){
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
