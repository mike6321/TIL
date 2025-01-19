package com.example.java.concurrent.chapter10.example09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class ScheduledAtFixedRateExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                log.info("Thread: {}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ScheduledFuture<?> future1 = scheduler.scheduleAtFixedRate(task, 1, 1, SECONDS);
        ScheduledFuture<?> future2 = scheduler.scheduleAtFixedRate(task, 1, 1, SECONDS);
        ScheduledFuture<?> future3 = scheduler.scheduleAtFixedRate(task, 1, 1, SECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        future1.cancel(true);
        future2.cancel(true);
        future3.cancel(true);
        scheduler.shutdown();
    }

}
