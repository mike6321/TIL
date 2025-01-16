package com.example.java.concurrent.chapter10.example02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;

@Slf4j
public class AsyncExecutorExample {

    public static void main(String[] args) {
        Executor asyncExecutor = new AsyncExecutor();
        asyncExecutor.execute(() -> {
            log.info("동기 작업1 수행 중...");
            log.info("동기 작업1 수행 완료...");
        });

        asyncExecutor.execute(() -> {
            log.info("동기 작업2 수행 중...");
            log.info("동기 작업2 수행 완료...");
        });
    }

    static class AsyncExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();  // 비동기 실행
        }

    }

}
