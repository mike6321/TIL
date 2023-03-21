package com.choi.core.fetcher;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.internals.Fetcher;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.utils.Timer;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class KafkaConsumerWrapper<K, V> {

    private final Fetcher<K, V> fetcher;

    /**
     * @see org.apache.kafka.clients.consumer.KafkaConsumer#pollForFetches(Timer)
     *
     * nextInLineRecords와 completedFetches를 확인하여 브로커로부터 이미 가져온 데이터가 있는 경우에는
     * max.poll.records 설정 값만큼 레코드를 반환
     * */
    private Map<TopicPartition, List<ConsumerRecord<K, V>>> pollForFetches(Timer timer) {
        final Map<TopicPartition, List<ConsumerRecord<K, V>>> records = fetcher.fetchedRecords();

        if (!records.isEmpty()) {
            return records;
        }

        fetcher.sendFetches();

        return fetcher.fetchedRecords();
    }

}
