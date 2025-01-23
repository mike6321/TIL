package com.example.java.concurrent.chapter11.example02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer finalResult = CompletableFuture.supplyAsync(() -> {
            log.info("Service01 is running");
            return 10;
        }).thenApplyAsync(result -> {
            log.info("Service02 is running");
            return result * 10;
        }).thenApplyAsync(result -> {
            log.info("Service03 is running");
            return result * 10;
        }).get();

        log.info("Result: {}", finalResult);
    }

}
