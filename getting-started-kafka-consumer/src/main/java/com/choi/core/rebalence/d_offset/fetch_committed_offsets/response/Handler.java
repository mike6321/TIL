package com.choi.core.rebalence.d_offset.fetch_committed_offsets.response;

import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.requests.OffsetCommitResponse;
import org.apache.kafka.common.requests.OffsetFetchResponse;

public class Handler {

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator.OffsetFetchResponseHandler#handle(OffsetFetchResponse, RequestFuture)
     * */
    public void handle(OffsetCommitResponse response, RequestFuture<Void> future) {

    }

}
