package com.example.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        reentrantLock.lock();  // 락 획득
        try {
            count++;
        } finally {
            reentrantLock.unlock();  // 락 해제
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLockExample counter = new ReentrantLockExample();

        // 스레드 10개를 생성하여 각 스레드에서 카운터의 increment 메서드를 호출
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // 모든 스레드가 종료될 때까지 대기
        for (Thread thread : threads) {
            thread.join();
        }

        // 최종 카운트 값을 출력
        System.out.println("Final count: " + counter.getCount());
    }

}
