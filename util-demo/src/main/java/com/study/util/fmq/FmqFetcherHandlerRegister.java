/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.study.util.fmq;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.skywalking.apm.agent.core.fmq.FmqReporterPluginConfig;

import com.focustech.fmq.clients.consumer.config.ConsumerConfig;
import com.focustech.fmq.clients.consumer.impl.FMQConsumer;
import com.focustech.kafka.clients.consumer.ConsumerRecord;
import com.focustech.kafka.clients.consumer.ConsumerRecords;
import com.focustech.kafka.clients.consumer.OffsetResetStrategy;
import com.focustech.kafka.common.utils.Bytes;
import com.focustech.serialization.AbstractDeserializer;

/**
 * Configuring and initializing a KafkaConsumer client as a dispatcher to delivery Kafka Message to registered handler by topic.
 */

public class FmqFetcherHandlerRegister {
    public static void main(String[] args) {
        ConsumerConfig consumerConfig = new ConsumerConfig("LOCAL", "192.168.53.26:9092,192.168.53.27:9092,192.168.53.28:9092", "consumer-demo1");
        consumerConfig.setDeserializer(new FmqBytesDeserializer());
        consumerConfig.setAutoOffsetReset(OffsetResetStrategy.LATEST);
        FMQConsumer consumer = new FMQConsumer(consumerConfig);
        consumer.subscribe(FmqReporterPluginConfig.Plugin.Fmq.TOPIC_METRICS);

        while (true) {
            ConsumerRecords<String, Bytes> consumerRecords = consumer.pollDeserialized(Duration.ofMillis(500L).toMillis(), Bytes.class);
            if (!consumerRecords.isEmpty()) {
                Iterator<ConsumerRecord<String, Bytes>> iterator = consumerRecords.iterator();
                while (iterator.hasNext()) {
                    ConsumerRecord<String, Bytes> record = iterator.next();
                    handle(record.value());
                }
                consumer.commitAsync();
            }

            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private static void handle(Bytes bytes){
        try {
            System.out.println("recocrd = " + new String(bytes.get(), "UTF-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }


    public static class FmqBytesDeserializer extends AbstractDeserializer {

        @Override
        protected <T> T doDeserialize(byte[] bytes, Class<T> aClass) throws Throwable {
            return (T) new Bytes(bytes);
        }
    }

}
