package com.choi.core.rebalence.d_offset.c_commit.auto_commit;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.internals.ConsumerCoordinator;
import org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.requests.OffsetCommitResponse;
import org.apache.kafka.common.utils.Timer;

import java.util.Map;

@RequiredArgsConstructor
public class ConsumerCoordinatorWrapper {

    private final boolean autoCommitEnabled;
    private final int autoCommitIntervalMs;
    protected final ConsumerNetworkClient client;
    private Timer nextAutoCommitTimer;
    private Node coordinator = null;

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerCoordinator#maybeAutoCommitOffsetsAsync(long)
     * */
    public void maybeAutoCommitOffsetsAsync(long now) {
        if (autoCommitEnabled) {
            nextAutoCommitTimer.update(now);
            if (nextAutoCommitTimer.isExpired()) {
                nextAutoCommitTimer.reset(autoCommitIntervalMs);
                doAutoCommitOffsetsAsync();
            }
        }
    }

    /**
     * @see ConsumerCoordinator#doAutoCommitOffsetsAsync()
     * */
    private void doAutoCommitOffsetsAsync() {

    }

    /**
     * @see ConsumerCoordinator#sendOffsetCommitRequest(Map)
     * @see ConsumerCoordinator.OffsetCommitResponseHandler#handle(OffsetCommitResponse, RequestFuture)
     * */
    RequestFuture<Void> sendOffsetCommitRequest(final Map<TopicPartition, OffsetAndMetadata> offsets) {
        return client.send(coordinator, null)
                .compose(null); // OffsetCommitResponseHandler
    }

}
