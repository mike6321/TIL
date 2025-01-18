package com.example.java.concurrent.chapter10.example06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class SummitLamdaExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
            return "Hello World";
        });

        String result = future.get();
        log.info("비동기 작업 결과: {}", result);

        executorService.shutdown();
    }

}
