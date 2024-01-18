package com.example.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFairness {

    private final ReentrantLock lock = new ReentrantLock(true); // 공정한 락 설정

    public void performTask() {
        lock.lock();  // 락 획득
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            // 락을 획득한 후 작업을 수행 (예: 1초 대기)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // 락 해제
            System.out.println(Thread.currentThread().getName() + " released the lock");
        }
    }

    public static void main(String[] args) {
        ReentrantLockFairness example = new ReentrantLockFairness();

        // 여러 스레드 생성 및 시작
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(example::performTask, "Thread-" + i);
            try {
                Thread.sleep(100 * i); // 각 스레드 시작 시간에 약간의 지연을 추가
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            thread.start();
        }
    }


}
