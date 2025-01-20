package com.example.java.concurrent.chapter10.example11;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class PreStartThreadsExample {

    public static void main(String[] args) {
        final int corePoolSize = 2;
        final int maximumPoolSize = 4;
        final int keepAliveTime = 0;
        final TimeUnit unit = TimeUnit.SECONDS;
        final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        executor.prestartCoreThread();
//        executor.prestartAllCoreThreads();

        int taskNum = 9;
        for (int i = 0; i < taskNum; i++) {
            final int taskId = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("{}, 가 태스크 {} 를 실행하고 있습니다.", Thread.currentThread().getName(), taskId);
            });
        }

        executor.shutdown();
    }

}
