package com.example.java.concurrent.chapter03.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class d_InterruptedExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("인터럽트 상태1: {}", Thread.currentThread().isInterrupted());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.info("thread 가 interrupt 되었습니다.");
                log.info("인터럽트 상태2: {}", Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
            }
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
        thread.join();
        log.info("인터럽트 상태3: {}", thread.isInterrupted());
    }

}
