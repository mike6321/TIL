package com.choi.core.response;

import org.apache.kafka.clients.ClientResponse;
import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.RequestCompletionHandler;
import org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.common.utils.Timer;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConsumerNetworkClientWrapper {

    private final KafkaClient client;
    private final ConcurrentLinkedQueue<RequestFutureCompletionHandler> pendingCompletion = new ConcurrentLinkedQueue<>();

    public ConsumerNetworkClientWrapper(KafkaClient client) {
        this.client = client;
    }

    public class RequestFutureCompletionHandler implements RequestCompletionHandler {

        /**
         * @see org.apache.kafka.common.protocol.ApiKeys
         * @see org.apache.kafka.common.requests.AbstractResponse
         * */
        private ClientResponse response;
        private final RequestFuture<ClientResponse> future;

        public RequestFutureCompletionHandler(RequestFuture<ClientResponse> future) {
            this.future = future;
        }

        /**
         * @see org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient
         *
         * 브로커로부터 응답 결과를 pendingCompletion 에 적재
         * */
        @Override
        public void onComplete(ClientResponse response) {
            this.response = response;
            pendingCompletion.add(this);
        }

        public void fireCompletion() {
            future.complete(response);
        }
    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.ConsumerNetworkClient#poll(Timer, ConsumerNetworkClient.PollCondition, boolean)
     *
     * 1. pendingCompletion 에 적재된 데이터 전송
     * 2. pendingCompletion 에 적재된 데이터 적재
     * */
    public void poll(Timer timer, ConsumerNetworkClient.PollCondition pollCondition, boolean disableWakeup) {
        firePendingCompletedRequests();
        client.poll(0, timer.currentTimeMs());
    }

    /**
     * pendingCompletion 에 적재된 데이터 전송
     * */
    private void firePendingCompletedRequests() {
        boolean completedRequestsFired = false;
        for (;;) {
            RequestFutureCompletionHandler completionHandler = pendingCompletion.poll();
            if (completionHandler == null)
                break;

            completionHandler.fireCompletion();
            completedRequestsFired = true;
        }

        // wakeup the client in case it is blocking in poll for this future's completion
        if (completedRequestsFired)
            client.wakeup();
    }

}
