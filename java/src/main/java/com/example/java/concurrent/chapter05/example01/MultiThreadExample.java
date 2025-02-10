package com.example.java.concurrent.chapter05.example01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiThreadExample {

    private static int sum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread thread01 = new Thread(() -> {
            for (int i = 1; i <= 500; i++) {
                synchronized (lock) {
                    sum += i;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread02 = new Thread(() -> {
            for (int i = 501; i <= 1000; i++) {
                synchronized (lock) {
                    sum += i;
                }
                try {
                    Thread.sleep(1);
//                    throw new RuntimeException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread01.start();
        thread02.start();

        try {
            thread01.join();
            thread02.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("sum: {}", sum);
        log.info("실행 시간: {}", System.currentTimeMillis() - start);
    }

}
