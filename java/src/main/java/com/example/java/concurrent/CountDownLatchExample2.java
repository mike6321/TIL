package com.example.java.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample2 {
    public static void main(String[] args) {
        int numberOfThreads = 3;

        for (int stage = 1; stage <= 3; stage++) {
            CountDownLatch latch = new CountDownLatch(numberOfThreads);

            for (int i = 0; i < numberOfThreads; i++) {
                int finalStage = stage;
                new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": 단계 " + finalStage + " 작업 실행");
                        // 여기에 작업 로직 추가
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            try {
                latch.await();
                System.out.println("모든 단계 " + stage + " 완료. 다음 단계로 진행.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
