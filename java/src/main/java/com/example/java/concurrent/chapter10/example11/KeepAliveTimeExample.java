package com.example.java.concurrent.chapter10.example11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.*;

public class KeepAliveTimeExample {

    public static void main(String[] args) throws InterruptedException {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        // corePoolSize 를 제외한 나머지 스레드는 keepAliveTime 이 지나면 종료된다.
        long keepAliveTime = 1L;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        int taskNum = 6;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, SECONDS, workQueue);

        for (int i = 0; i < taskNum; i++) {
            final int taskId = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ", 가 태스크 " + taskId + " 를 실행하고 있습니다.");
            });
        }

        // corePoolSize 도 keepAliveTime 이 지나면 종료된다.
        executor.allowCoreThreadTimeOut(true);

        Thread.sleep(4000);
        executor.shutdown();
    }

}
