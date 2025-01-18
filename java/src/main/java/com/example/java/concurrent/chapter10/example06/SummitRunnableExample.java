package com.example.java.concurrent.chapter10.example06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class SummitRunnableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future01 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
            }
        });
        Object result01 = future01.get();
        log.info("비동기 작업 결과: {}", result01);


        Future<String> future02 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
            }
        }, "Hello World");
        String result02 = future02.get();
        log.info("비동기 작업 결과: {}", result02);

        executorService.shutdown();
    }

}
