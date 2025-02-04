package com.example.java.concurrent.chapter04.example02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class FlagThreadStopExample02 {

    private AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) {
        new FlagThreadStopExample02().flagTest();
    }

    private void flagTest() {
        new Thread(() -> {
            int count = 0;
           while (running.get()) {
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
            running.set(false);
        }).start();
    }

}
