package com.choi.core.rebalence.d_offset;

import org.apache.kafka.clients.GroupRebalanceConfig;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.requests.OffsetFetchRequest;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Request {

    private Node coordinator = null;
    protected final ConsumerNetworkClient client;
    private final GroupRebalanceConfig rebalanceConfig;

    public Request(ConsumerNetworkClient client, GroupRebalanceConfig rebalanceConfig) {
        this.client = client;
        this.rebalanceConfig = rebalanceConfig;
    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator#sendOffsetFetchRequest(Set)
     * */
    private RequestFuture<Map<TopicPartition, OffsetAndMetadata>> sendOffsetFetchRequest(Set<TopicPartition> partitions) {
        // checkAndGetCoordinator

        // construct the request
        OffsetFetchRequest.Builder requestBuilder =
                new OffsetFetchRequest.Builder(this.rebalanceConfig.groupId, true, new ArrayList<>(partitions), true);

        // send the request with a callback
        return client.send(coordinator, requestBuilder)
                .compose(null); // OffsetFetchResponseHandler
    }

}
