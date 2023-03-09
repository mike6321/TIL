package com.choi.core.subscribe;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;

import java.util.Set;

public class RegisterSubscriptionStateWrapper {

    private ConsumerRebalanceListener rebalanceListener;
    private SubscriptionType subscriptionType;
    private Set<String> subscription;

    private enum SubscriptionType {
        NONE, AUTO_TOPICS, AUTO_PATTERN, USER_ASSIGNED
    }

    /**
     * @see org.apache.kafka.clients.consumer.internals.SubscriptionState#subscribe(Set, ConsumerRebalanceListener)
     *
     * 토픽정보 등록
     * */
    public synchronized boolean subscribe(Set<String> topics, ConsumerRebalanceListener listener) {
        registerRebalanceListener(listener);
        setSubscriptionType(SubscriptionType.AUTO_TOPICS);
        return changeSubscription(topics);
    }

    private void registerRebalanceListener(ConsumerRebalanceListener listener) {
        this.rebalanceListener = listener;
    }

    private void setSubscriptionType(SubscriptionType type) {
        if (this.subscriptionType == SubscriptionType.NONE)
            this.subscriptionType = type;
    }

    private boolean changeSubscription(Set<String> topicsToSubscribe) {
        if (subscription.equals(topicsToSubscribe))
            return false;

        subscription = topicsToSubscribe;
        return true;
    }

}
