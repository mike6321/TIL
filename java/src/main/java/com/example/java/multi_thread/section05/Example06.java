package com.example.java.multi_thread.section05;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example06 {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        Thread thread01 = new Thread(() -> {
            int localCounter = counter; // cache memory
            while (localCounter < 10) {
                if (localCounter != counter) {
                    log.info("local counter is changed");
                    localCounter = counter;
                }
            }
        });
        Thread thread02 = new Thread(() -> {
            int localCounter = counter;
            while (localCounter < 10) {
                log.info("incremented counter to {}", (localCounter + 1));
                counter = ++localCounter;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread01.start();
        thread02.start();
    }

}
