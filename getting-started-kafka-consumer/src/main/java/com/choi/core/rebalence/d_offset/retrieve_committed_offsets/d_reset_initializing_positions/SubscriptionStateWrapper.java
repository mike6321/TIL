package com.choi.core.rebalence.d_offset.retrieve_committed_offsets.d_reset_initializing_positions;

import org.apache.kafka.clients.consumer.internals.SubscriptionState;

public class SubscriptionStateWrapper {

    private final SubscriptionState subscriptionState;

    public SubscriptionStateWrapper(SubscriptionState subscriptionState) {
        this.subscriptionState = subscriptionState;
    }

    /**
     * @see SubscriptionState.TopicPartitionState#transitionState(SubscriptionState.FetchState, Runnable)
     *
     * partitionState 패치전략이 INITIALIZING 인것 대상으로
     * 패치전략 AWAIT_RESET 으로 변경
     * 리셋 전략 설정 [LATEST, EARLIEST, NONE]
     * position null 로 초기화
     * */
    public synchronized void resetInitializingPositions() {
        subscriptionState.resetInitializingPositions();
    }


}
