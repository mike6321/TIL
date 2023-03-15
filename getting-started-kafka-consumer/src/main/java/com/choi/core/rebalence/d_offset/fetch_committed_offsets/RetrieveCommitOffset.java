package com.choi.core.rebalence.d_offset.fetch_committed_offsets;

import org.apache.kafka.clients.consumer.internals.ConsumerCoordinator;
import org.apache.kafka.clients.consumer.internals.Fetcher;
import org.apache.kafka.clients.consumer.internals.SubscriptionState;
import org.apache.kafka.common.utils.Timer;

public class RetrieveCommitOffset<K, V> {

    private final Fetcher<K, V> fetcher;
    private final ConsumerCoordinator coordinator;
    private final SubscriptionState subscriptions;

    public RetrieveCommitOffset(Fetcher<K, V> fetcher, ConsumerCoordinator coordinator, SubscriptionState subscriptions) {
        this.fetcher = fetcher;
        this.coordinator = coordinator;
        this.subscriptions = subscriptions;
    }

    /**
     * @see org.apache.kafka.clients.consumer.KafkaConsumer#updateFetchPositions(Timer)
     * */
    private boolean updateFetchPositions(final Timer timer) {

        if (coordinator != null && !coordinator.refreshCommittedOffsetsIfNeeded(timer)) return false;

        subscriptions.resetInitializingPositions();

        fetcher.resetOffsetsIfNeeded();

        return true;
    }

}
