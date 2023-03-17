package com.choi.core.rebalence.d_offset.retrieve_partitions_offsets;

import org.apache.kafka.clients.consumer.internals.Fetcher;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.clients.consumer.internals.RequestFutureListener;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.requests.ListOffsetsResponse;

import java.util.Map;

public class FetcherWrapper<T> {

    /**
     * @see Fetcher#resetOffsetsIfNeeded()
     * @see Fetcher#resetOffsetsAsync(Map) ()
     * 
     * 파티션의 오프셋 정보 요청
     * */
    public void resetOffsetsIfNeeded(final Map<TopicPartition, Long> offsetResetTimestamps) {
        resetOffsetsAsync(offsetResetTimestamps);
    }

    /**
     * @see Fetcher#resetOffsetsAsync(Map)
     * */
    private void resetOffsetsAsync(Map<TopicPartition, Long> offsetResetTimestamps) {
        RequestFuture<T> future = sendListOffsetRequest();
        future.addListener(new RequestFutureListener<T>() {
            @Override
            public void onSuccess(Object value) {
                // 후처리
            }

            @Override
            public void onFailure(RuntimeException e) {

            }
        });
    }

    /**
     * @see Fetcher#sendListOffsetRequest(Node, Map, boolean)
     * */
    private RequestFuture<T> sendListOffsetRequest() {
        handleListOffsetResponse();
        return new RequestFuture<>();
    }


    /**
     * @see Fetcher#handleListOffsetResponse(ListOffsetsResponse, RequestFuture)
     *
     * 파티션의 오프셋 정보 응답
     * 응답으로 받은 오프셋 값은 SubscriptionState의 seek 메서드를 통해 파티션의 초기 오프셋으로 설정
     * */
    private void handleListOffsetResponse() {

    }

}
