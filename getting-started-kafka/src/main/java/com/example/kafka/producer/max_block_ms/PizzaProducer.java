package com.example.kafka.producer.max_block_ms;

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
        /**
         * send() 호출 시 RecordAccumulator 에 입력하지 못하고 Block 되는 최대시간.
         * -> 초과 시 Timeout Exception
         * */
        configs.setProperty(ProducerConfig.MAX_BLOCK_MS_CONFIG, "50000");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configs);
        sendPizzaMessage(kafkaProducer, TOPIC_NAME, -1, 1000, 0, 0, false);
    }

}
