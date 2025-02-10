package com.example.java.concurrent.chapter04.example05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolThreadLocalExample {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            threadLocal.set("작업 1의 값 ");
            log.info("{}: {}", Thread.currentThread().getName(), threadLocal.get());
            threadLocal.remove(); // required
        });

        sleep();

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> log.info("{}: {}", Thread.currentThread().getName(), threadLocal.get()));
        }

        shutdown(executorService);
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
    }

    private static void sleep() {
        try {
            Thread.sleep(2L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
