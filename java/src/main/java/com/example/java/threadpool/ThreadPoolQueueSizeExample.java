package com.example.java.threadpool;

import java.util.concurrent.*;

public class ThreadPoolQueueSizeExample {
    public static void main(String[] args) {
        // 1. 스레드 풀 생성 (corePoolSize = 1, maxPoolSize = 1, queueSize = 1)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,                       // corePoolSize
                1,                       // maximumPoolSize
                0L,                      // keepAliveTime
                TimeUnit.MILLISECONDS,   // keepAliveTime 단위
                new ArrayBlockingQueue<>(1), // 큐 크기를 1로 설정
                new ThreadPoolExecutor.AbortPolicy() // 작업이 거부될 경우 예외 발생
        );

        // 2. 작업 정의
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is executing task.");
                Thread.sleep(2000); // 2초 동안 작업 수행
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // 3. 작업 제출
        try {
            System.out.println("Submitting Task 1");
            executor.submit(task); // 첫 번째 작업 제출 (실행)

            System.out.println("Submitting Task 2");
            executor.submit(task); // 두 번째 작업 제출 (큐에 대기)

            System.out.println("Submitting Task 3");
            executor.submit(task); // 세 번째 작업 제출 (거부될 예정)
        } catch (RejectedExecutionException e) {
            System.out.println("Task was rejected: " + e.getMessage());
        } finally {
            executor.shutdown(); // 스레드 풀 종료
        }
    }
}
