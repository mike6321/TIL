package com.choi.core.rebalence.d_offset.fetch_committed_offsets.retrieve_commited_offsets_from_coordinator;

import org.apache.kafka.clients.GroupRebalanceConfig;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.requests.OffsetFetchResponse;

import java.util.HashMap;
import java.util.Map;

public class Handler {

    private final GroupRebalanceConfig rebalanceConfig;

    public Handler(GroupRebalanceConfig rebalanceConfig) {
        this.rebalanceConfig = rebalanceConfig;
    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator.OffsetFetchResponseHandler#handle(OffsetFetchResponse, RequestFuture)
     * @see OffsetFetchResponse#responseDataV0ToV7()
     * */
    public void handle(OffsetFetchResponse response, RequestFuture<Void> future) {
        // response data convert
        // key : TopicPartition value : PartitionData
        Map<TopicPartition, OffsetFetchResponse.PartitionData> responseData =
                response.partitionDataMap(rebalanceConfig.groupId);
        Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>(responseData.size());
        for (Map.Entry<TopicPartition, OffsetFetchResponse.PartitionData> entry : responseData.entrySet()) {
            TopicPartition tp = entry.getKey();
            OffsetFetchResponse.PartitionData partitionData = entry.getValue();
            if (partitionData.hasError()) {

            }
            // 커밋된 내용이 있는 경우
            else if (partitionData.offset >= 0) {
                offsets.put(tp, new OffsetAndMetadata(partitionData.offset, partitionData.leaderEpoch, partitionData.metadata));
            }
            // 커밋된 내용이 없는 경우
            else {
                offsets.put(tp, null);
            }
        }

    }

}
