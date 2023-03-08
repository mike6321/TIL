package com.choi.core.request;

import org.apache.kafka.clients.ClientResponse;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.requests.AbstractRequest;

public class ConsumerNetworkClientWrapper {

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient#send(Node, AbstractRequest.Builder, int)
     * @return RequestFuture<ClientResponse>
     *
     * ConsumerNetworkClient 는 ClientRequest 를 바로 전송하지 않고 내부 버퍼인 Unsent Map 에 먼저 저장한다.
     * Unsent Map 의 Key 는 요청을 전송할 브로커의 호스트이고 Value는 브로커로 전송해야 하는 ClientRequest 의 리스트이다.
     *
     * ClientRequest 의 전송은 ConsumerNetworkClient의 poll 메서드가 호출될 때 이루어진다.
     */
    public RequestFuture<ClientResponse> send(Node node,
                                              AbstractRequest.Builder<?> requestBuilder,
                                              int requestTimeoutMs) {
        return null;
    }

}
