package com.example.java.concurrent.chapter10.example06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExecuteExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
        });

//        new Thread(() -> {
//            log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
//        }).start();
        executorService.shutdown();
    }

}
