package com.choi.basic.commit;

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

/**
 * 69 -> shutdown
 * record key: H001, partition: 0, record offset: 70, record value: order_id:ord71, shop:H001, pizza_name:Potato Pizza, customer_name:Dessie Fritsch, phone_number:1-831-624-9641 x515, address:823 Reilly Knolls, time:2023-03-05 23:48:46
 * */
public class CommitConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(CommitConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-commit-topic");

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList("commit-topic"));

        pollAutoCommit(consumer);
    }

    private static void pollAutoCommit(KafkaConsumer<String, String> consumer) {
        int loopCount = 0;
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1000));
                log.info("### loopCount : {}, consumerRecords count: {}", loopCount++, records.count());
                for (ConsumerRecord<String, String> record : records) {
                    log.info("record key: {}, partition: {}, record offset: {}, record value: {}", record.key(), record.partition(), record.offset(), record.value());
                }
                try {
                    log.info("main thread is sleeping {}ms during while loop", 10000);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
