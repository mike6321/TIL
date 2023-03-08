package com.choi.core.response;

import org.apache.kafka.clients.ClientResponse;

import java.util.List;

public class NetworkClientWrapper {

    /**
     * @see org.apache.kafka.clients.NetworkClient#completeResponses(List)
     *
     * 브로커로부터 응답 결과를 받아온다.
     * 받아온 결과를 콜백 객체를 통해 ConsumerNetworkClinent 로 전달
     * @see ConsumerNetworkClientWrapper.RequestFutureCompletionHandler#onComplete
     * */
    private void completeResponses(List<ClientResponse> responses) {
        for (ClientResponse response : responses) {
            response.onComplete();
        }
    }

}
