package com.example.java.concurrent.chapter04.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserThreadLifecycleExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                log.info("사용자 스레드 1 실행 중");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("사용자 스레드 1 종료");
        });

        Thread thread02 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                log.info("사용자 스레드 2 실행 중");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("사용자 스레드 2 종료");
        });

        thread01.start();
        thread02.start();

//        thread01.join();
//        thread02.join();

        log.info("모든 사용자 스레드 및 메인 스레드 종료");
    }

}
