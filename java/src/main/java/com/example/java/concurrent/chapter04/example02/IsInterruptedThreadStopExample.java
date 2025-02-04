package com.example.java.concurrent.chapter04.example02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsInterruptedThreadStopExample {

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                log.info("작업 스레드가 실행 중입니다.");
            }
            log.info("인터럽트 상태: {}", Thread.currentThread().isInterrupted());
            log.info("작업 스레드가 종료되었습니다.");
        });

        Thread stopperThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            workerThread.interrupt();
            log.info("중단 스레드가 작업 스레드를 인터럽트했습니다.");
        });

        workerThread.start();
        stopperThread.start();

        workerThread.join();
        stopperThread.join();
    }

}
