package com.example.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@Slf4j
public class ProducerAsyncWithKey {

    private final static String TOPIC_NAME = "topic01";
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        for(int seq=0; seq < 20; seq++) {
            //ProducerRecord object creation
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_NAME, String.valueOf(seq),"hello world " + seq);
            log.info("seq:" + seq);
            //kafkaProducer message send
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        log.info("\n ###### record metadata received ##### \n" +
                                "partition:" + metadata.partition() + "\n" +
                                "offset:" + metadata.offset() + "\n" +
                                "timestamp:" + metadata.timestamp());
                    } else {
                        log.error("exception error from broker " + exception.getMessage());
                    }
                }
            });

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
