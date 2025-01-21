package com.example.java.concurrent.chapter10.example11;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DiscardPolicyExample {

    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 2;
        long keepAliveTime = 0;
        int workQueueCapacity = 2;

        /**
         * @see ThreadPoolExecutor.DiscardPolicy#rejectedExecution(Runnable, ThreadPoolExecutor)
         *
         * 09:43:15.002 [pool-1-thread-2] INFO com.example.java.concurrent.chapter10.example11.DiscardPolicyExample - Task 2 is running on thread pool-1-thread-2
         * 09:43:15.002 [pool-1-thread-1] INFO com.example.java.concurrent.chapter10.example11.DiscardPolicyExample - Task 1 is running on thread pool-1-thread-1
         * 09:43:16.009 [pool-1-thread-1] INFO com.example.java.concurrent.chapter10.example11.DiscardPolicyExample - Task 4 is running on thread pool-1-thread-1
         * 09:43:16.009 [pool-1-thread-2] INFO com.example.java.concurrent.chapter10.example11.DiscardPolicyExample - Task 3 is running on thread pool-1-thread-2
         * */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(workQueueCapacity),
                new ThreadPoolExecutor.DiscardPolicy() );

        submitTasks(executor);
    }

    private static void submitTasks(ThreadPoolExecutor executor) {
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                log.info("Task {} is running on thread {}", taskId, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
    }

}
