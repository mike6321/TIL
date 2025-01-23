package com.example.java.concurrent.chapter11.example04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class RunAsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 반환 값이 없다.
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            log.info("{} 가 비동기 작업을 시작합니다.", Thread.currentThread().getName());
        });
    }

}
