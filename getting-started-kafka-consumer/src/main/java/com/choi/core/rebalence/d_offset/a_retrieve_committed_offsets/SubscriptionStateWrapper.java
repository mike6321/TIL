package com.choi.core.rebalence.d_offset.a_retrieve_committed_offsets;

import org.apache.kafka.common.TopicPartition;

import java.util.Set;

public class SubscriptionStateWrapper {

    /**
     * @see org.apache.kafka.clients.consumer.internals.SubscriptionState#partitionsNeedingReset(long)
     *
     * */
    public synchronized Set<TopicPartition> partitionsNeedingReset(long nowMs) {
        return null;
    }
    
}
