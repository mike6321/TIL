package com.example.java.concurrent.chapter03.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class a_InterruptExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            log.info("thread01 작업시작");
            log.info("thread01 interrupt 상태: {}", Thread.currentThread().isInterrupted());
        });
        Thread thread02 = new Thread(() -> {
            thread01.interrupt();
            log.info("thread02 이 thread01을 interrupt 시킴");
            log.info("thread02 interrupt 상태: {}", Thread.currentThread().isInterrupted());
        });

        thread01.start();
        Thread.sleep(1000);
        thread02.start();

        try {
            thread01.join();
            thread02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
