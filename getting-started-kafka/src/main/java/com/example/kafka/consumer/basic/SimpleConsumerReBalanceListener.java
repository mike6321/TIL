package com.example.kafka.consumer.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

@Slf4j
public class SimpleConsumerReBalanceListener extends AbstractConsumer {

    public static void main(String[] args) {
        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(List.of(TOPIC_NAME), new ReBalanceListener());
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : records) {
                log.info("{}", record);
            }
        }
    }

    static class ReBalanceListener implements ConsumerRebalanceListener {

        @Override
        public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
            log.warn("Partitions are assigned : " + partitions.toString());
        }

        @Override
        public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
            log.warn("Partitions are revoked : " + partitions.toString());
        }

    }
}
