package com.example.kafka.core;

import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.internals.ProducerInterceptors;
import org.apache.kafka.clients.producer.internals.ProducerMetadata;
import org.apache.kafka.clients.producer.internals.Sender;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.utils.KafkaThread;
import org.apache.kafka.common.utils.LogContext;
import org.apache.kafka.common.utils.Time;

/**
 * @see org.apache.kafka.clients.producer.KafkaProducer
 */
public class CreateKafkaProducerNetworkThreadCore<K, V> {

    public static final String NETWORK_THREAD_PREFIX = "kafka-producer-network-thread";

    private final String clientId;
    private final ProducerMetadata metadata;
    private final Sender sender;
    private final Thread ioThread;
    private final ProducerConfig producerConfig;


    /**
     * @see org.apache.kafka.clients.producer.KafkaProducer#KafkaProducer
     * */
    CreateKafkaProducerNetworkThreadCore(ProducerConfig config,
                                         Serializer<K> keySerializer,
                                         Serializer<V> valueSerializer,
                                         ProducerMetadata metadata,
                                         KafkaClient kafkaClient,
                                         ProducerInterceptors<K, V> interceptors,
                                         Time time) {
        this.producerConfig = config;
        this.clientId = config.getString(ProducerConfig.CLIENT_ID_CONFIG);
        this.metadata = metadata;
        LogContext logContext = new LogContext(String.format("[Producer clientId=%s] ", clientId));
        this.sender = newSender(logContext, kafkaClient, this.metadata);
        String ioThreadName = NETWORK_THREAD_PREFIX + " | " + clientId;
        this.ioThread = new KafkaThread(ioThreadName, this.sender, true);
        this.ioThread.start();
    }

    /**
     * @see org.apache.kafka.clients.producer.KafkaProducer#newSender
     * */
    Sender newSender(LogContext logContext, KafkaClient kafkaClient, ProducerMetadata metadata) {
        return new Sender(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

}
