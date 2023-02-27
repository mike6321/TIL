package com.example.kafka.producer.linger;

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
         * Sender Thread는 개별 메세지 배치를 가져가기전 최대 linger.ms 만큼 기다린 후 브로커 전송
         * */
        configs.setProperty(ProducerConfig.LINGER_MS_CONFIG, "50000");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configs);
        sendPizzaMessage(kafkaProducer, TOPIC_NAME, -1, 1000, 0, 0, false);
    }

}
