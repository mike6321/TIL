package com.choi.core.rebalence.a_find_coordinator;

import org.apache.kafka.clients.ClientResponse;
import org.apache.kafka.common.utils.Time;

import java.util.ArrayList;
import java.util.List;

public class NetworkClientWrapper {

    private final Time time = Time.SYSTEM;

    /**
     * @see org.apache.kafka.clients.NetworkClient#poll(long, long)
     * @see org.apache.kafka.common.requests.FindCoordinatorResponse
     *
     *
     * */
    public List<ClientResponse> poll(long timeout, long now) {
        long updatedNow = this.time.milliseconds();
        List<ClientResponse> responses = new ArrayList<>();

        handleCompletedReceives(responses, updatedNow); // broker 로부터 받은 FIND_COORDINATOR response

        return responses;
    }

    private void handleCompletedReceives(List<ClientResponse> responses, long now) {

    }

}
