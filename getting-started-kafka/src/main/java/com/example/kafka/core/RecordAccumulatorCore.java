package com.example.kafka.core;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.internals.FutureRecordMetadata;
import org.apache.kafka.clients.producer.internals.ProducerBatch;
import org.apache.kafka.clients.producer.internals.RecordAccumulator;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.header.Header;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentMap;

@RequiredArgsConstructor
public class RecordAccumulatorCore {

    private final ConcurrentMap<TopicPartition, Deque<ProducerBatch>> batches;

    /**
     * @see org.apache.kafka.clients.producer.internals.RecordAccumulator#getOrCreateDeque
     * 배치생성
     * 최초생성시 value 에 빈 Dequeue 객체생성
     * Key : tp - "topic01-0" value : Dequeue
     * */
    private Deque<ProducerBatch> getOrCreateDeque(TopicPartition tp) {
        Deque<ProducerBatch> d = this.batches.get(tp);
        if (d != null)
            return d;
        d = new ArrayDeque<>();
        Deque<ProducerBatch> previous = this.batches.putIfAbsent(tp, d);
        if (previous == null)
            return d;
        else
            return previous;
    }

    /**
     * @see org.apache.kafka.clients.producer.internals.RecordAccumulator#tryAppend
     * @see org.apache.kafka.clients.producer.internals.ProducerBatch#tryAppend
     *
     * 만약 Dequeue에 토픽의 값이 존재한다면
     * 배치에 해당 레코드가 들어갈 공간이 존재하면 thunks add
     * */
    private RecordAccumulator.RecordAppendResult tryAppend(long timestamp, byte[] key, byte[] value, Header[] headers,
                                                           Callback callback, Deque<ProducerBatch> deque, long nowMs) {
        ProducerBatch last = deque.peekLast();
        if (last != null) {
            FutureRecordMetadata future = last.tryAppend(timestamp, key, value, headers, callback, nowMs);
            if (future == null)
                last.closeForRecordAppends();
            else
                return new RecordAccumulator.RecordAppendResult(future, deque.size() > 1 || last.isFull(), false, false);
        }
        return null;
    }

}
