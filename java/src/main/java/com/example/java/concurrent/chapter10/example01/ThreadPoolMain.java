package com.example.java.concurrent.chapter10.example01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadPoolMain {

    public static void main(String[] args) {
        // 스레드 풀 생성 (3개의 스레드를 가진 스레드 풀)
        SimpleThreadPool threadPool = new SimpleThreadPool(3);

        // 작업을 스레드 풀에 제출
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            threadPool.submit(() -> {
                // 작업 내용
                log.info("작업 " + taskId + " 수행 중...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                log.info("작업 " + taskId + " 완료.");
            });
        }

        // 스레드 풀 종료
        threadPool.shutdown();
    }

}
