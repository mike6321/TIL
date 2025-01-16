package com.example.java.concurrent.chapter10.example02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;

@Slf4j
public class SyncExecutorExample {

    public static void main(String[] args) {
        Executor syncExecutor = new SyncExecutor();
        syncExecutor.execute(() -> {
            log.info("동기 작업1 수행 중...");
            log.info("동기 작업1 수행 완료...");
        });

        syncExecutor.execute(() -> {
            log.info("동기 작업2 수행 중...");
            log.info("동기 작업2 수행 완료...");
        });
    }

    static class SyncExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            command.run();  // 동기 실행
        }

    }

}
