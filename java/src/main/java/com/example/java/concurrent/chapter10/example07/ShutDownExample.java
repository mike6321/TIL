package com.example.java.concurrent.chapter10.example07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ShutDownExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                    log.info("{}, 작업 완료", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                return 40;
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                /**
                 * @see ThreadPoolExecutor#interruptWorkers()
                 * */
                executorService.shutdownNow(); // 강제 종료 시 interrupt() 호출
                log.info("모든 작업을 강제 종료함");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        if (executorService.isShutdown()) {
            log.info("스레드 풀 종료 여부: {}", executorService.isShutdown());
        }
        while (!executorService.isTerminated()) {
            log.info("스레드 풀 종료 중");
        }
        log.info("스레드 풀 종료됨");
    }

}
