package com.example.java.concurrent.chapter03.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class a_InterruptExample2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                log.info("thread 작업 진행중");
                if (Thread.interrupted()) {
                    log.info("인터럽트 상태가 초기화 되었습니다.");
                    break;
                }
            }
            log.info("thread interrupt 상태: {}", Thread.currentThread().isInterrupted());
            Thread.currentThread().interrupt();
            log.info("thread interrupt 상태: {}", Thread.currentThread().isInterrupted());
        });

        thread.start();
        Thread.sleep(1000);

        thread.interrupt();
    }

}
