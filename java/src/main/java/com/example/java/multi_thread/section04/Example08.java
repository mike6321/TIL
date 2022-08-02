package com.example.java.multi_thread.section04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Example08 {

    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static int intValue = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
                intValue++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
                intValue++;
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
                intValue++;
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        log.info("The atomic number is {}", atomicInteger.get());
        log.info("The primitive number is {}", intValue);
    }

}
