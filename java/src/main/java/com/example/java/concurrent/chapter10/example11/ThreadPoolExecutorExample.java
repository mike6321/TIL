package com.example.java.concurrent.chapter10.example11;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        final int corePoolSize = 2;
        final int maximumPoolSize = 4;
        final int keepAliveTime = 0;
        final TimeUnit unit = TimeUnit.SECONDS;

        // 무한대로 큐에 작업을 쌓을 수 있음
        // maximumPoolSize 가 의미가 없어진다.
//        final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(4);

        /**
         * @see java.util.concurrent.ThreadPoolExecutor#ThreadPoolExecutor(int, int, long, java.util.concurrent.TimeUnit, java.util.concurrent.BlockingQueue)
         * */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

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
