package com.choi.basic.assign;

import com.choi.AbstractConsumer;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

/**
 * bin/kafka-topics.sh --bootstrap-server my-kafka:9092 --describe --topic explicit-partition-topic
 *
 * record key: D001, partition: 0, record offset: 4, record value: order_id:ord9, shop:D001, pizza_name:Potato Pizza, customer_name:Dr. Curtis Hettinger, phone_number:838.586.0286, address:608 Moore Port, time:2023-03-06 21:04:25
 * */
public class ExplicitPartitionAssignConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(ExplicitPartitionAssignConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-assign-topic");
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        consumer = new KafkaConsumer<>(configs);
        String topicName = "explicit-partition-topic";
        TopicPartition topicPartition = new TopicPartition(topicName, 0);
        consumer.assign(Arrays.asList(topicPartition));

        pollCommitSync(consumer);
    }

    private static void pollCommitSync(KafkaConsumer<String, String> consumer) {
        int loopCount = 0;
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1000));
                log.info("### loopCount : {}, consumerRecords count: {}", loopCount++, records.count());
                for (ConsumerRecord<String, String> record : records) {
                    log.info("record key: {}, partition: {}, record offset: {}, record value: {}", record.key(), record.partition(), record.offset(), record.value());
                }
                try {
                    if (records.count() > 0) {
                        consumer.commitSync();
                        log.info("commit sync has been called...!");
                    }
                } catch (CommitFailedException e) {
                    log.error(e.getMessage());
                }
            }
        } catch (WakeupException e) {
            log.warn("Wakeup consumer");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("Consumer close");
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
