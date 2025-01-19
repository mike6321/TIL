package com.example.java.concurrent.chapter10.example09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class ScheduledRunnableExample {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            log.info("작업이 한 번 실행됩니다.");
        };

        scheduler.schedule(task, 3, SECONDS);

        Thread.sleep(5000);

        scheduler.shutdown();
    }

}
