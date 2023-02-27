package com.example.kafka.producer.setting.custom_partitioning;

import com.example.kafka.producer.AbstractProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static com.example.kafka.producer.SendPizzaMessage.sendPizzaMessage;

public class PizzaProducer extends AbstractProducer {

    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);
        configs.put("specialKey", "P001");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configs);
        sendPizzaMessage(kafkaProducer, CUSTOM_PARTITIONER_TOPIC_NAME, -1, 1000, 0, 0, false);
    }

}
