package com.choi.core.rebalence.d_offset.retrieve_committed_offsets;

import org.apache.kafka.common.utils.Timer;

public class ConsumerCoordinatorWrapper {

    /**
     * @see org.apache.kafka.clients.consumer.KafkaConsumer#updateFetchPositions(Timer)
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator#refreshCommittedOffsetsIfNeeded(Timer)
     * */
    public boolean refreshCommittedOffsetsIfNeeded(Timer timer) {
        return true;
    }

}
