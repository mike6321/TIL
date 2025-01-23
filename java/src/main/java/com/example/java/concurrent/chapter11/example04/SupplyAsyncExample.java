package com.example.java.concurrent.chapter11.example04;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class SupplyAsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();

        CompletableFuture<List<Integer>> cf = CompletableFuture.supplyAsync(() -> {
            log.info("{} 가 비동기 작업을 시작합니다.", Thread.currentThread().getName());
            return myService.getData();
        });
        cf.get().forEach(result -> log.info("결과: {}", result));
    }

    static class MyService {
        public List<Integer> getData() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(1, 2, 3);
        }
    }

}
