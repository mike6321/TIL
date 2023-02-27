package com.example.kafka.producer;

import com.github.javafaker.Faker;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class SendPizzaMessage {

    public static final Logger logger = LoggerFactory.getLogger(SendPizzaMessage.class.getName());

    public static void sendPizzaMessage(KafkaProducer<String, String> kafkaProducer,
                                        String topicName,
                                        int iterCount,
                                        int interIntervalMillis,
                                        int intervalMillis,
                                        int intervalCount,
                                        boolean sync) {
        PizzaMessage pizzaMessage = new PizzaMessage();

        long seed = 2022;
        Random random = new Random(seed);
        Faker faker = Faker.instance(random);

        int iterSeq = 0;
        while (iterSeq++ != iterCount) {
            Map<String, String> message = pizzaMessage.produce_msg(faker, random, iterSeq);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(
                    topicName,
                    message.get("key"),
                    message.get("message")
            );

            sendMessage(kafkaProducer, producerRecord, message, sync);

            if ((intervalCount > 0) && (iterSeq % intervalCount == 0)) {
                try {
                    logger.info("### intervalCount: " + intervalCount + " intervalMillis:" + intervalMillis + "###");
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (interIntervalMillis > 0) {
                try {
                    logger.info("### interIntervalMillis: " + interIntervalMillis + "###");
                    Thread.sleep(interIntervalMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendMessage(KafkaProducer<String, String> producer,
                                   ProducerRecord<String, String> producerRecord,
                                   Map<String, String> message,
                                   boolean sync) {
        if (!sync) {
            async(producer, producerRecord, message);
        } else {
            sync(producer, producerRecord, message);
        }
    }

    private static void async(KafkaProducer<String, String> producer, ProducerRecord<String, String> producerRecord, Map<String, String> message) {
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    logger.info("async message: " + message.get("key") + " partition: " + metadata.partition());
                    logger.info("offset:" + metadata.offset());
                } else {
                    logger.error("exception error from broker " + exception.getMessage());
                }
            }
        });
    }

    private static void sync(KafkaProducer<String, String> producer, ProducerRecord<String, String> producerRecord, Map<String, String> message) {
        RecordMetadata metadata = null;
        try {
            metadata = producer.send(producerRecord).get();
            logger.info("sync message: " + message.get("key") + " partition: " + metadata.partition());
            logger.info("offset:" + metadata.offset());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
