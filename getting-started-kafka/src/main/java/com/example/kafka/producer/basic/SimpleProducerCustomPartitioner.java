package com.example.kafka.producer.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class SimpleProducerCustomPartitioner {

    private final static String TOPIC_NAME = "test";
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);

        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        ProducerRecord<String, String> record01 = new ProducerRecord<>(TOPIC_NAME, "Pangyo", "Pangyo");
        producer.send(record01);
        log.info("{}", record01);
        ProducerRecord<String, String> record02 = new ProducerRecord<>(TOPIC_NAME, "Busan", "Busan");
        producer.send(record02);
        log.info("{}", record02);
        producer.flush();
        producer.close();
    }

    static class CustomPartitioner implements Partitioner {

        @Override
        public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
            if (keyBytes == null) {
                throw new InvalidRecordException("Need message key");
            }
            if (key.equals("Pangyo")) {
                return 0;
            }

            List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
            int numPartitions = partitions.size();
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        }

        @Override
        public void close() {

        }

        @Override
        public void configure(Map<String, ?> configs) {

        }

    }

}
