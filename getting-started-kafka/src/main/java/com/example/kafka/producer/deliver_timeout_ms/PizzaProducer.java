package com.example.kafka.producer.deliver_timeout_ms;

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
         * Producer 메세지 전송에 허용된 최대 시간
         * (delivery.timeout.ms >= linger.ms + request.timeout.ms)
         * -> 초과 시 retry 를 하거나 Timeout Exception 발생
         * */
        configs.setProperty(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, "50000");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configs);
        sendPizzaMessage(kafkaProducer, TOPIC_NAME, -1, 1000, 0, 0, false);
    }

}
