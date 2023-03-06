package com.choi.commit;

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
 * wakeUp 하지 않고 종료
 * 강제 종료
 * 612 offset 까지 poll
 *
 * consumer 실행 시 605 부터 poll
 * [605 ~ 612] duplicate read
 * */
public class DuplicateReadCommitConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(DuplicateReadCommitConsumer.class.getName());

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
//            consumer.wakeup();

            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
