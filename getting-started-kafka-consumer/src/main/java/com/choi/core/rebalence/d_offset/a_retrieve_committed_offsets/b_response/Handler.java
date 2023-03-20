package com.choi.core.rebalence.d_offset.a_retrieve_committed_offsets.b_response;

import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.requests.OffsetFetchResponse;

public class Handler {

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator.OffsetFetchResponseHandler#handle(OffsetFetchResponse, RequestFuture)
     * */
    public void handle(OffsetFetchResponse response, RequestFuture<Void> future) {

    }

}
