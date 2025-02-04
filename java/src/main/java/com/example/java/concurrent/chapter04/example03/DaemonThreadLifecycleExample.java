package com.example.java.concurrent.chapter04.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonThreadLifecycleExample {

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                log.info("사용자 스레드 실행 중");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    log.info("데몬 스레드 실행 중");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        userThread.join();
        log.info("메인 스레드 종료");
    }

}
