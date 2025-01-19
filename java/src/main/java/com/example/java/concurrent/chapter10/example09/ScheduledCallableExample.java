package com.example.java.concurrent.chapter10.example09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

@Slf4j
public class ScheduledCallableExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Callable<String> task = () -> {
            return "Hello, World!";
        };

        ScheduledFuture<String> future = scheduler.schedule(task, 3, SECONDS);

        try {
            String result = future.get();
            log.info("result: {}", result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        scheduler.shutdown();
    }

}
