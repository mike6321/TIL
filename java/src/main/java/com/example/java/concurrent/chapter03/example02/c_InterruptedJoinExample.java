package com.example.java.concurrent.chapter03.example02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class c_InterruptedJoinExample {

    public static void main(String[] args) throws InterruptedException {

        Thread mainThread = Thread.currentThread();

        Thread longRunningThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    log.info("긴 작업 스레드가 계속 실행 중...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                mainThread.interrupt();
                log.info("긴 작업 스레드가 인터럽트 되었습니다.");
            }
        });
        longRunningThread.start();

        Thread interruptingThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                longRunningThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        interruptingThread.start();

        try {
            log.info("메인 스레드가 긴 작업 스레드의 완료를 기다립니다.");
            longRunningThread.join();
            log.info("메인 스레드 작업완료.");
        } catch (InterruptedException e) {
            log.info("메인 스레드가 인터럽트 되었습니다.");
        }

    }

}
