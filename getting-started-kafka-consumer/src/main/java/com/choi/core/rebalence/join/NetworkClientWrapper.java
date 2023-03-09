package com.choi.core.rebalence.join;

import org.apache.kafka.clients.ClientResponse;
import org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.message.JoinGroupRequestData;
import org.apache.kafka.common.requests.JoinGroupRequest;
import org.apache.kafka.common.utils.Time;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class NetworkClientWrapper {

    private final Time time = Time.SYSTEM;
    protected ConsumerNetworkClient client;
    private Node coordinator = null;

    /**
     * @see org.apache.kafka.clients.NetworkClient#poll(long, long)
     * @see org.apache.kafka.common.message.JoinGroupRequestData
     *
     * @see org.apache.kafka.common.requests.JoinGroupResponse
     * 1. leader x
     * 2. leader o, member o
     * */
    public List<ClientResponse> poll(long timeout, long now) {
        long updatedNow = this.time.milliseconds();
        List<ClientResponse> responses = new ArrayList<>();

        handleCompletedReceives(responses, updatedNow); // broker 로부터 받은 FIND_COORDINATOR response

        return responses;
    }

    private void handleCompletedReceives(List<ClientResponse> responses, long now) {

    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.AbstractCoordinator#sendJoinGroupRequest
     * groupId
     * 컨슈머가 속할 그룹을 나타낸다.
     * sessionTimeout
     * 컨슈머가 sessionTimeout 시간 내에 heartbeat 요청을 GroupCoordinator에 보내지 않으면 GroupCoordinator는 해당 컨슈머가 죽은 것으로 판단한다.
     * session.timeout.ms를 통해 설정한다.
     * rebalanceTimeout
     * 그룹에 속한 컨슈머들은 리밸런스가 발생했을 때 rebalanceTimeout 이내에 JoinGroup 요청을 보내야 한다. rebalanceTimeout 이내에 JoinGroup 요청을 보내지 않은 컨슈머는 컨슈머 그룹에서 제외된다.
     * rebalanceTimeout은 max.poll.interval.ms으로 설정된다.
     * groupProtocols
     * 메타데이터로 컨슈머가 구독하려는 토픽과 컨슈머가 지원하는 파티션 할당 정책이 포함된다.
     * 컨슈머가 지원하는 파티션 할당 정책은 partition.assignment.strategy을 통해 설정한다. partition.assignment.strategy의 기본값은 org.apache.kafka.clients.consumer.RangeAssignor이다.
     * */
    RequestFuture<ByteBuffer> sendJoinGroupRequest() {
        // send a join group request to the coordinator
        JoinGroupRequest.Builder requestBuilder = new JoinGroupRequest.Builder(
                new JoinGroupRequestData()
                        .setGroupId(null)
                        .setSessionTimeoutMs(0)
                        .setMemberId(null)
                        .setGroupInstanceId(null)
                        .setProtocolType(null)
                        .setProtocols(null)
                        .setRebalanceTimeoutMs(0)
        );

        return client.send(coordinator, requestBuilder, 0)
                .compose(null);
    }

}
