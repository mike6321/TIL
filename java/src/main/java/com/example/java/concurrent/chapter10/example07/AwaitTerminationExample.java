package com.example.java.concurrent.chapter10.example07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Slf4j
public class AwaitTerminationExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("custom-thread");
                thread.setDaemon(true);
                return thread;
            }
        });

        executorService.submit(() -> {
            while (true) {
                try {
                    log.info("데몬 스레드 실행 중: {}", Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        });
        executorService.shutdown();
//        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        Thread.sleep(3000);
        log.info("메인 스레드 종료");

    }

}
