package com.example.java.multi_thread.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExecutorExample {

    public static void main(String[] args) {
        int numberOfCpu = Runtime.getRuntime().availableProcessors();
//        step01();
//        step02();
//        step03();
//        step04();
        step05();
        log.info("numberOfCpu :: {}", numberOfCpu);
        log.info("{} hello", Thread.currentThread());
    }

    private static void step05() {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }

    private static void step04() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }

    private static void step03() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }

    private static void step02() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }

    private static void step01() {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("{} world", Thread.currentThread());
        }

    }

}
