package com.example.kafka.core;

import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.internals.ProducerMetadata;
import org.apache.kafka.clients.producer.internals.Sender;
import org.apache.kafka.common.utils.LogContext;

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

    public CreateKafkaProducerNetworkThreadCore(String clientId, ProducerMetadata metadata, Sender sender, Thread ioThread, ProducerConfig producerConfig) {
        this.clientId = clientId;
        this.metadata = metadata;
        this.sender = sender;
        this.ioThread = ioThread;
        this.producerConfig = producerConfig;
    }

    /**
     * @see org.apache.kafka.clients.producer.KafkaProducer#KafkaProducer
     * */
//    CreateKafkaProducerNetworkThreadCore(ProducerConfig config,
//                                         Serializer<K> keySerializer,
//                                         Serializer<V> valueSerializer,
//                                         ProducerMetadata metadata,
//                                         KafkaClient kafkaClient,
//                                         ProducerInterceptors<K, V> interceptors,SubscriptionState
//                                         Time time) {
//        this.producerConfig = config;
//        this.clientId = config.getString(ProducerConfig.CLIENT_ID_CONFIG);
//        this.metadata = metadata;
//        LogContext logContext = new LogContext(String.format("[Producer clientId=%s] ", clientId));
//        this.sender = newSender(logContext, kafkaClient, this.metadata);
//        String ioThreadName = NETWORK_THREAD_PREFIX + " | " + clientId;
//        this.ioThread = new KafkaThread(ioThreadName, this.sender, true);
//        this.ioThread.start();
//    }

    /**
     * @see org.apache.kafka.clients.producer.KafkaProducer#newSender
     * */
    Sender newSender(LogContext logContext, KafkaClient kafkaClient, ProducerMetadata metadata) {
        return new Sender(null, null, null, null, true, 0, (short) 0, 0, null, null, 0, 0, null, null);
    }

}
