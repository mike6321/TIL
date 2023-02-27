package com.example.kafka.producer;

public abstract class AbstractProducer {

    protected final static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    protected final static String TOPIC_NAME = "topic01";
    protected final static String CUSTOM_PARTITIONER_TOPIC_NAME = "topic02";

}
