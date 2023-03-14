package com.choi.core.rebalence.c_assign;

import org.apache.kafka.clients.consumer.ConsumerPartitionAssignor;
import org.apache.kafka.clients.consumer.internals.ConsumerProtocol;

import java.nio.ByteBuffer;

public class Serialization {

    public void serialize(ConsumerPartitionAssignor.Assignment assignment) {
        ConsumerProtocol.serializeAssignment(assignment);
    }

    public void deserialize(ByteBuffer buffer) {
        ConsumerProtocol.deserializeAssignment(buffer);
    }
    
}
