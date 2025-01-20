package com.example.java.concurrent.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class LinkedBlockingQueueExample {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        // 생성자 스레드
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    log.info("생산자: {} 를 넣었습니다.", i);
                    queue.put(i);
                    Thread.sleep(10000); // 생산자는 1초마다 데이터를 생산
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 소비자 스레드
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Integer value = queue.take();
                    log.info("소비자: {} 를 꺼냈습니다.", value);
                    Thread.sleep(100); // 소비자는 0.1초마다 데이터를 소비
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
