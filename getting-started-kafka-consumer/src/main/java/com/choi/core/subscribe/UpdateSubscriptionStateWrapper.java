package com.choi.core.subscribe;

import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.internals.PartitionStates;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UpdateSubscriptionStateWrapper {

    private PartitionStates<TopicPartitionState> assignment;
    private int assignmentId = 0;

    /**
     * @see org.apache.kafka.clients.consumer.internals.SubscriptionState#assignFromSubscribed(Collection)
     *
     * assignment 등록
     * */
    public synchronized void assignFromSubscribed(Collection<TopicPartition> assignments) {
        Map<TopicPartition, TopicPartitionState> assignedPartitionStates = new HashMap<>(assignments.size());
        for (TopicPartition tp : assignments) {
            TopicPartitionState state = this.assignment.stateValue(tp);
            if (state == null)
                state = new TopicPartitionState();
            assignedPartitionStates.put(tp, state);
        }

        assignmentId++;
        this.assignment.set(assignedPartitionStates);
    }

    private static class TopicPartitionState {

    }

}
