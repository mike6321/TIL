package com.choi.basic.commit;

import com.choi.AbstractConsumer;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

public class ManualAsyncCommitConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(ManualAsyncCommitConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-commit-topic");
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList("commit-topic"));

        pollCommitAsync(consumer);
    }

    private static void pollCommitAsync(KafkaConsumer<String, String> consumer) {
        int loopCount = 0;
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1000));
                log.info("### loopCount : {}, consumerRecords count: {}", loopCount++, records.count());
                for (ConsumerRecord<String, String> record : records) {
                    log.info("record key: {}, partition: {}, record offset: {}, record value: {}", record.key(), record.partition(), record.offset(), record.value());
                }
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                        if (e != null) {
                            log.error("offsets {} is not completed, error: {}", map, e);
                        }
                    }
                });
            }
        } catch (WakeupException e) {
            log.warn("Wakeup consumer");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("### commit sync before closing...");
            consumer.commitSync();
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
