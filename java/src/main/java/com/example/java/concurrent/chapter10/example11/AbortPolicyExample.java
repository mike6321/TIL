package com.example.java.concurrent.chapter10.example11;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AbortPolicyExample {

    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 2;
        long keepAliveTime = 0;
        int workQueueCapacity = 2;

        /**
         * @see java.util.concurrent.ThreadPoolExecutor#reject(Runnable) 
         * @see java.util.concurrent.ThreadPoolExecutor.AbortPolicy#rejectedExecution(Runnable, ThreadPoolExecutor)
         *
         * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@2ff5659e[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@75828a0f[Wrapped task = com.example.java.concurrent.chapter10.example11.AbortPolicyExample$$Lambda$31/0x0000000801011320@3abfe836]] rejected from java.util.concurrent.ThreadPoolExecutor@6a38e57f[Running, pool size = 2, active threads = 2, queued tasks = 2, completed tasks = 0]
         * 	at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2081)
         * 	at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:841)
         * 	at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1376)
         * 	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:123)
         * 	at com.example.java.concurrent.chapter10.example11.AbortPolicyExample.submitTasks(AbortPolicyExample.java:36)
         * 	at com.example.java.concurrent.chapter10.example11.AbortPolicyExample.main(AbortPolicyExample.java:30)
         * 09:39:27.956 [pool-1-thread-1] INFO com.example.java.concurrent.chapter10.example11.AbortPolicyExample - Task 1 is running on thread pool-1-thread-1
         * 09:39:27.956 [pool-1-thread-2] INFO com.example.java.concurrent.chapter10.example11.AbortPolicyExample - Task 2 is running on thread pool-1-thread-2
         * 09:39:28.960 [pool-1-thread-1] INFO com.example.java.concurrent.chapter10.example11.AbortPolicyExample - Task 4 is running on thread pool-1-thread-1
         * 09:39:28.960 [pool-1-thread-2] INFO com.example.java.concurrent.chapter10.example11.AbortPolicyExample - Task 3 is running on thread pool-1-thread-2
         * */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(workQueueCapacity),
                new ThreadPoolExecutor.AbortPolicy());

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
