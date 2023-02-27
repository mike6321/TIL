package com.example.kafka.producer.idempotence;

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
         * 명시적 설정 x :
         *
         * [기본설정]
         * enable.idempotence = true
         * max.in.flight.requests.per.connection = 5
         * retries = 2147483647
         * */

        /**
         * 명시적 설정 x :
         * 잘못된 설정을 아래와 같이 하였을 시
         * enable.idempotence = fasle 로 설정된다.
         * */
//        configs.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "6");
//        configs.put(ProducerConfig.ACKS_CONFIG, "0");

        /**
         * 명시적 설정 o :
         * 잘못된 설정을 아래와 같이 하였을 시
         * ConfigException 발생 -> "Must set acks to all in order to use the idempotent producer. Otherwise we cannot guarantee idempotence."
         *
         * @see <a href="https://docs.confluent.io/platform/current/installation/configuration/producer-configs.html#enable-idempotence"><a/>
         * */
        configs.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        configs.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "6");
        configs.put(ProducerConfig.ACKS_CONFIG, "0");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configs);
        sendPizzaMessage(kafkaProducer, TOPIC_NAME, -1, 1000, 0, 0, false);
    }

}
