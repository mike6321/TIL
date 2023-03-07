package com.choi.basic.assign;

import com.choi.AbstractConsumer;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

/**
* bin/kafka-consumer-groups.sh --bootstrap-server my-kafka:9092 --describe --group group-assign-topic
 *
 *
 * Revoke previously assigned partitions topic-p3-t1-0, topic-p3-t2-1, topic-p3-t2-0, topic-p3-t1-2, topic-p3-t1-1, topic-p3-t2-2
 * Adding newly assigned partitions: topic-p3-t2-0, topic-p3-t1-1, topic-p3-t2-2
 * Adding newly assigned partitions: topic-p3-t2-1, topic-p3-t1-1
* */
public class RoundRobinAssignConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(RoundRobinAssignConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-assign-topic");
        configs.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, RoundRobinAssignor.class.getName());

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList("topic-p3-t1", "topic-p3-t2"));

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
