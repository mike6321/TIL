package com.example.java.concurrent.chapter04.example02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlagThreadStopExample01 {

    private static volatile boolean running = true;

    public static void main(String[] args) {
        new Thread(() -> {
            int count = 0;
           while (running) {
                count++;
           }
           log.info("Thread stopped. count: {}", count);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Thread stopping...");
            running = false;
        }).start();
    }

}
