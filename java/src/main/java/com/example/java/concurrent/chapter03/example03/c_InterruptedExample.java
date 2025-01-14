package com.example.java.concurrent.chapter03.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class c_InterruptedExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            //interrupt 상태가 초기화 된다.
            while (!Thread.interrupted()) {
                log.info("thread01 작업 진행중");
            }
            log.info("thread01 이 interrupt 되었음");
            log.info("thread01 interrupt 상태: {}", Thread.currentThread().isInterrupted());
        });

        thread01.start();
        Thread.sleep(1000);

        thread01.interrupt();
        log.info("thread01 interrupt 시도");
        log.info("thread01 interrupt 상태: {}", thread01.isInterrupted());
    }

}
