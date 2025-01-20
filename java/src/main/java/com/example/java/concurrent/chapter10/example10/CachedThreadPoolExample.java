package com.example.java.concurrent.chapter10.example10;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("Thread Name: {}", Thread.currentThread().getName());
            });
        }

        /**
         * @see java.util.concurrent.Executors#newCachedThreadPool()
         * 60s 가 지나면 쓰레드를 종료한다.
         * */
        try {
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

}
