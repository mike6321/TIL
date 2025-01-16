package com.example.java.concurrent.chapter10.example03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<Integer> callableTask = () -> {
            log.info("Callable 작업 수행 중...");
            log.info("Callable 작업 수행 완료...");
            return 7;
        };

        Future<Integer> submit = executorService.submit(callableTask);
        Integer result = submit.get();
        log.info("결과: {}", result);

        executorService.shutdown();
    }

}
