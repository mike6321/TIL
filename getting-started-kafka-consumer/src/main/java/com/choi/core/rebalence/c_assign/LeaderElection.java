package com.choi.core.rebalence.c_assign;

import org.apache.kafka.clients.consumer.internals.AbstractCoordinator;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.requests.JoinGroupResponse;

import java.nio.ByteBuffer;

public class LeaderElection {

    /**
     * @see org.apache.kafka.clients.consumer.internals.AbstractCoordinator.JoinGroupResponseHandler#handle(JoinGroupResponse, RequestFuture)
     *
     * 첫 번째 요청인 경우 리더로 선출 : 파티션 할당 역할 수행
     * 이후 요청
     * @see org.apache.kafka.clients.consumer.internals.AbstractCoordinator.JoinGroupResponseHandler#onJoinLeader(JoinGroupResponse)
     * @see AbstractCoordinator.JoinGroupResponseHandler#onJoinFollower()
     * */
    public void handle(JoinGroupResponse joinResponse, RequestFuture<ByteBuffer> future) {

    }

}
