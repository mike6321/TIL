package com.example.java.concurrent.chapter10.example08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyExample {

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
            Integer result = executorService.invokeAny(tasks);
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("소요 시간: " + (System.currentTimeMillis() - start) + "ms");
    }

}
