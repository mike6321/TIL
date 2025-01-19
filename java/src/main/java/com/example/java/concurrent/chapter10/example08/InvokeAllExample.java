package com.example.java.concurrent.chapter10.example08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {
            Thread.sleep(3000);
            return 1;
        });
        tasks.add(() -> {
            Thread.sleep(2000);
            return 2;
        });
        tasks.add(() -> {
            Thread.sleep(1000);
            throw new RuntimeException("예외 발생");
        });

        long start = 0;
        try {
            start = System.currentTimeMillis();
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            for (Future<Integer> future : futures) {
                try {
                    Integer result = future.get();
                    System.out.println("result: " + result);
                } catch (Exception e) {
                    System.out.println("예외 발생: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("소요 시간: " + (System.currentTimeMillis() - start) + "ms");
    }

}
