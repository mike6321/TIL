package com.example.java.concurrent.chapter04.example02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterruptedExceptionThreadStopExample04 {

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            try {
                while (true) {
                    log.info("작업 스레드가 실행 중입니다.");
                    log.info("인터럽트 상태1: {}", Thread.currentThread().isInterrupted());

                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException("스레드가 인터럽트 되었습니다.");
                    }
                }
            } catch (InterruptedException e) {
                // 임의로 InterruptedException 을 발생시키면 상태가 초기화되지 않는다.
                log.info("인터럽트 상태2: {}", Thread.currentThread().isInterrupted());
            }
            log.info("작업 스레드가 중단되었습니다.");
            log.info("인터럽트 상태3: {}", Thread.currentThread().isInterrupted());
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
