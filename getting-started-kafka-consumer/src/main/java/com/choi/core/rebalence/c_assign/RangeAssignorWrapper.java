package com.choi.core.rebalence.c_assign;

import org.apache.kafka.clients.consumer.ConsumerPartitionAssignor;
import org.apache.kafka.clients.consumer.internals.AbstractPartitionAssignor;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

public class RangeAssignorWrapper {

    /**
     * @see org.apache.kafka.clients.consumer.RangeAssignor#assign(Map, Map)
     * */
    public Map<String, List<TopicPartition>> assign(Map<String, Integer> partitionsPerTopic,
                                                    Map<String, ConsumerPartitionAssignor.Subscription> subscriptions) {
        Map<String, List<AbstractPartitionAssignor.MemberInfo>> consumersPerTopic = consumersPerTopic(subscriptions);

        Map<String, List<TopicPartition>> assignment = new HashMap<>();
        for (String memberId : subscriptions.keySet())
            assignment.put(memberId, new ArrayList<>());

        for (Map.Entry<String, List<AbstractPartitionAssignor.MemberInfo>> topicEntry : consumersPerTopic.entrySet()) {
            String topic = topicEntry.getKey();
            List<AbstractPartitionAssignor.MemberInfo> consumersForTopic = topicEntry.getValue();

            Integer numPartitionsForTopic = partitionsPerTopic.get(topic);
            if (numPartitionsForTopic == null)
                continue;

            Collections.sort(consumersForTopic);

            int numPartitionsPerConsumer = numPartitionsForTopic / consumersForTopic.size();
            int consumersWithExtraPartition = numPartitionsForTopic % consumersForTopic.size();

            List<TopicPartition> partitions = partitions(topic, numPartitionsForTopic);
            for (int i = 0, n = consumersForTopic.size(); i < n; i++) {
                int start = numPartitionsPerConsumer * i + Math.min(i, consumersWithExtraPartition);
                int length = numPartitionsPerConsumer + (i + 1 > consumersWithExtraPartition ? 0 : 1);
                assignment.get(consumersForTopic.get(i).memberId).addAll(partitions.subList(start, start + length));
            }
        }
        return assignment;
    }

    private Map<String, List<AbstractPartitionAssignor.MemberInfo>> consumersPerTopic(Map<String, ConsumerPartitionAssignor.Subscription> consumerMetadata) {
        Map<String, List<AbstractPartitionAssignor.MemberInfo>> topicToConsumers = new HashMap<>();
        for (Map.Entry<String, ConsumerPartitionAssignor.Subscription> subscriptionEntry : consumerMetadata.entrySet()) {
            String consumerId = subscriptionEntry.getKey();
            AbstractPartitionAssignor.MemberInfo memberInfo = new AbstractPartitionAssignor.MemberInfo(consumerId, subscriptionEntry.getValue().groupInstanceId());
            for (String topic : subscriptionEntry.getValue().topics()) {
                put(topicToConsumers, topic, memberInfo);
            }
        }
        return topicToConsumers;
    }

    protected static <K, V> void put(Map<K, List<V>> map, K key, V value) {
        List<V> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(value);
    }

    protected static List<TopicPartition> partitions(String topic, int numPartitions) {
        List<TopicPartition> partitions = new ArrayList<>(numPartitions);
        for (int i = 0; i < numPartitions; i++)
            partitions.add(new TopicPartition(topic, i));
        return partitions;
    }

}
