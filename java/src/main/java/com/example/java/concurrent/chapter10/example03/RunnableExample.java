package com.example.java.concurrent.chapter10.example03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class RunnableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Runnable runnableTask = () -> {
            log.info("Runnable 작업 수행 중...");
            log.info("Runnable 작업 수행 완료...");
        };

        executorService.submit(runnableTask);

        executorService.shutdown();
    }
}
