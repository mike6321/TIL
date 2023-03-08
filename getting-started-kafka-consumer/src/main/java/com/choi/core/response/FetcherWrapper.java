package com.choi.core.response;

import org.apache.kafka.clients.consumer.internals.Fetcher;

public class FetcherWrapper {

    /**
     * @see Fetcher#sendFetches()
     * */
    public synchronized int sendFetches() {
        return 0;
    }

}
