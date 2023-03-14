package com.choi.core.rebalence.c_assign;

import org.apache.kafka.clients.ClientResponse;
import org.apache.kafka.clients.consumer.internals.RequestFuture;
import org.apache.kafka.clients.consumer.internals.RequestFutureAdapter;
import org.apache.kafka.common.requests.JoinGroupRequest;
import org.apache.kafka.common.requests.OffsetCommitRequest;

import java.util.Objects;

public abstract class Handler<R, T>extends RequestFutureAdapter<ClientResponse, T> {

    final Generation sentGeneration;
    ClientResponse response;

    public Handler(Generation sentGeneration) {
        this.sentGeneration = sentGeneration;
    }

    protected abstract void handle(R response, RequestFuture<T> future);

    /**
     * @see org.apache.kafka.clients.consumer.internals.AbstractCoordinator.CoordinatorResponseHandler#onSuccess(ClientResponse, RequestFuture)
     * CoordinatorResponseHandler -> JoinGroupResponseHandler
     * chaining 형태
     * */
    @Override
    public void onSuccess(ClientResponse clientResponse, RequestFuture<T> future) {
        try {
            this.response = clientResponse;
            R responseObj = (R) clientResponse.responseBody();
            handle(responseObj, future);
        } catch (RuntimeException e) {
            if (!future.isDone())
                future.raise(e);
        }
    }

    protected static class Generation {
        public static final Generation NO_GENERATION = new Generation(
                OffsetCommitRequest.DEFAULT_GENERATION_ID,
                JoinGroupRequest.UNKNOWN_MEMBER_ID,
                null);

        public final int generationId;
        public final String memberId;
        public final String protocolName;

        public Generation(int generationId, String memberId, String protocolName) {
            this.generationId = generationId;
            this.memberId = memberId;
            this.protocolName = protocolName;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Generation that = (Generation) o;
            return generationId == that.generationId &&
                    Objects.equals(memberId, that.memberId) &&
                    Objects.equals(protocolName, that.protocolName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(generationId, memberId, protocolName);
        }

        @Override
        public String toString() {
            return "Generation{" +
                    "generationId=" + generationId +
                    ", memberId='" + memberId + '\'' +
                    ", protocol='" + protocolName + '\'' +
                    '}';
        }
    }
    
}
