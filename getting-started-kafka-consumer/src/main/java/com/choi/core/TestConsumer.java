package com.choi.core;

import com.choi.AbstractConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

public class TestConsumer extends AbstractConsumer  {

    public static final Logger log = LoggerFactory.getLogger(TestConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new TestConsumer.ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "test-topic");

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList("test-topic"));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("topic:{}, record key: {}, partition: {}, record offset: {}, record value: {}", record.topic(), record.key(), record.partition(), record.offset(), record.value());
                }
            }
        } catch (WakeupException e) {
            log.warn("Wakeup consumer");
        } finally {
            log.warn("Consumer close");
            consumer.close();
        }
    }

    static class ShutdownThread extends Thread {
        @Override
        public void run() {
            log.info("Shutdown hook");
            consumer.wakeup();

            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
