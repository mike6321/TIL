package com.example.java.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);

        Thread fuelCheck = new Thread(() -> {
            System.out.println("연료 체크 중...");
            // 연료 체크 작업
            latch.countDown();
            System.out.println("연료 체크 완료.");
        });

        Thread engineCheck = new Thread(() -> {
            System.out.println("엔진 체크 중...");
            // 엔진 체크 작업
            latch.countDown();
            System.out.println("엔진 체크 완료.");
        });

        Thread communicationCheck = new Thread(() -> {
            System.out.println("통신 시스템 체크 중...");
            // 통신 시스템 체크 작업
            latch.countDown();
            System.out.println("통신 시스템 체크 완료.");
        });

        fuelCheck.start();
        engineCheck.start();
        communicationCheck.start();

        // 모든 체크가 완료될 때까지 기다립니다.
        latch.await();
        System.out.println("모든 시스템 체크 완료. 로켓 발사 준비 완료!");
    }
}
