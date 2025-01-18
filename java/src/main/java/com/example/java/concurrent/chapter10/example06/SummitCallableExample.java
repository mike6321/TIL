package com.example.java.concurrent.chapter10.example06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SummitCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        });
        String result = future.get();
        log.info("비동기 작업 결과: {}", result);
        executorService.shutdown();
    }

}
