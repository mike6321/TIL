package com.choi.core.rebalence.d_offset.retrieve_committed_offsets.a_request;

import org.apache.kafka.clients.GroupRebalanceConfig;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.requests.OffsetFetchRequest;
import org.apache.kafka.common.utils.Timer;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ConsumerCoordinatorWrapper {

    private final GroupRebalanceConfig rebalanceConfig;
    private final ConsumerNetworkClient client;
    private final Node coordinator;

    public ConsumerCoordinatorWrapper(GroupRebalanceConfig rebalanceConfig, ConsumerNetworkClient client, Node coordinator) {
        this.rebalanceConfig = rebalanceConfig;
        this.client = client;
        this.coordinator = coordinator;
    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator#fetchCommittedOffsets(Set, Timer)
     * */
    public Map<TopicPartition, OffsetAndMetadata> fetchCommittedOffsets(final Set<TopicPartition> partitions,
                                                                        final Timer timer) {
        do {
            // contact coordinator to fetch committed offsets
            sendOffsetFetchRequest(partitions);
        } while (timer.notExpired());
        return null;
    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator#sendOffsetFetchRequest(Set)
     * */
    private RequestFuture<Map<TopicPartition, OffsetAndMetadata>> sendOffsetFetchRequest(Set<TopicPartition> partitions) {
        // construct the request
        OffsetFetchRequest.Builder requestBuilder =
                new OffsetFetchRequest.Builder(this.rebalanceConfig.groupId, true, new ArrayList<>(partitions), true);

        // send the request with a callback
        return client.send(coordinator, requestBuilder)
                .compose(null); //OffsetFetchResponseHandler
    }

}
