package com.example.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> System.out.println("모든 단계 완료. 다음 단계로 진행."));

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": 첫 번째 작업 실행");
                barrier.await();

                System.out.println(Thread.currentThread().getName() + ": 두 번째 작업 실행");
                barrier.await();

                System.out.println(Thread.currentThread().getName() + ": 세 번째 작업 실행");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(task).start();
        }
    }
}
