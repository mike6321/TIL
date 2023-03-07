package com.choi.basic.setting.max_poll_interval_ms;

import com.choi.AbstractConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

public class MaxPollIntervalMsConsumer extends AbstractConsumer {

    public static final Logger log = LoggerFactory.getLogger(MaxPollIntervalMsConsumer.class.getName());

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group02");
        configs.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "60000");
        /**
         * 60초가 지나면 리밸런싱 진행
         * [2023-03-05 20:21:14,681] INFO [GroupCoordinator 0]: Member[group.instance.id None, member.id consumer-group02-1-6cb0c9e9-79b8-4300-9c32-ed74a85bf54c] in group group02 has left, removing it from the group (kafka.coordinator.group.GroupCoordinator)
         * [2023-03-05 20:21:14,682] INFO [GroupCoordinator 0]: Preparing to rebalance group group02 in state PreparingRebalance with old generation 1 (__consumer_offsets-43) (reason: removing member consumer-group02-1-6cb0c9e9-79b8-4300-9c32-ed74a85bf54c on LeaveGroup) (kafka.coordinator.group.GroupCoordinator)
         * [2023-03-05 20:21:14,683] INFO [GroupCoordinator 0]: Group group02 with generation 2 is now empty (__consumer_offsets-43) (kafka.coordinator.group.GroupCoordinator)
         * [2023-03-05 20:21:24,639] INFO [GroupCoordinator 0]: Preparing to rebalance group group02 in state PreparingRebalance with old generation 2 (__consumer_offsets-43) (reason: Adding new member consumer-group02-1-00f7d5ae-b78a-4cc0-8191-195e53abe0bb with group instance id None) (kafka.coordinator.group.GroupCoordinator)
         * */

        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        int loopCount = 0;
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1000));
                log.info("### loopCount : {}, consumerRecords count: {}", loopCount++, records.count());
                for (ConsumerRecord<String, String> record : records) {
                    log.info("record key: {}, partition: {}, record offset: {}, record value: {}", record.key(), record.partition(), record.offset(), record.value());
                }
                try {
                    log.info("main thread is sleeping {}ms during while loop", loopCount*10000);
                    Thread.sleep(loopCount * 10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (WakeupException e) {
            log.warn("Wakeup consumer");
        } finally {
            log.warn("Consumer close");
            consumer.close();
        }
    }

    static class ShutdownThread extends Thread {
        @Override
        public void run() {
            log.info("Shutdown hook");
            consumer.wakeup();

            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
