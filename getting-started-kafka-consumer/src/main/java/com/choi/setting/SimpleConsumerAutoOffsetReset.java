package com.choi.setting;

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
 * AUTO_OFFSET_RESET_CONFIG earliest 는
 * __consumer_offsets 에 있는 정보를 기반으로 메세지를 가져오기 때문에 earliest 로 설정하여도
 * 0번 오프셋 부터 읽어 들이지 않는다.
 *
 * -> __consumer_offsets 에 정보가 없을 때 유효한 설정
 * */
public class SimpleConsumerAutoOffsetReset extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(SimpleConsumerAutoOffsetReset.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("record key: {}, record value: {}, partition: {}, record offset: {}", record.key(), record.value(), record.partition(), record.offset());
                }
                consumer.commitSync();
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
