package com.example.java.concurrent.chapter11.example05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class ThenApplyExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();

        /**
         * @see CompletableFuture#postComplete()
         * */
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            getThreadInfo();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 40;
        }).thenApply(result -> {
            getThreadInfo();
            Integer data01 = myService.getData01();
            return result + data01;
        }).thenApplyAsync(result -> {
            getThreadInfo();
            Integer data02 = myService.getData02();
            return result + data02;
        });

        Integer result = completableFuture.get();
        System.out.println("result = " + result);
    }

    private static void getThreadInfo() {
        log.info("thread: {}", Thread.currentThread().getName());
    }

    static class MyService {
        public Integer getData01() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 50;
        }

        public Integer getData02() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 60;
        }
    }

}
