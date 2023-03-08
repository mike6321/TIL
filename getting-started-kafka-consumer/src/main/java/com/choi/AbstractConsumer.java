package com.choi;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public abstract class AbstractConsumer {

    protected final static String TOPIC_NAME = "topic01";
    protected final static String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
    protected final static String GROUP_ID = "test-group";
    protected final static Properties configs = new Properties();
    protected static KafkaConsumer<String, String> consumer;

    static {
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    }

}
