package com.choi.basic.commit;

import com.choi.AbstractConsumer;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

public class ManualSyncCommitConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(ManualSyncCommitConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-commit-topic");
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList("commit-topic"));

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
