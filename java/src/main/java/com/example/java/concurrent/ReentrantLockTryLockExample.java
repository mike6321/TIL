package com.example.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void performTask(boolean delay) {
        try {
            // 락을 획득하려고 시도, 최대 1초 동안 대기
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    // 락을 획득한 후 수행할 작업
                    System.out.println("Lock acquired, performing task");

                    // thread1에만 특별히 추가된 지연
                    if (delay) {
                        // 시간 지연을 위해 추가된 코드 (예: 2초 대기)
                        Thread.sleep(2000);
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                // 락 획득에 실패한 경우 수행할 작업
                System.out.println("Could not acquire lock, doing alternative task");
            }
        } catch (InterruptedException e) {
            // 대기 중 인터럽트 발생 처리
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while acquiring the lock");
        }
    }

    public static void main(String[] args) {
        ReentrantLockTryLockExample example = new ReentrantLockTryLockExample();

        // thread1에 대한 호출, 지연을 추가하여 락을 오래 보유하도록 함
        Thread thread1 = new Thread(() -> example.performTask(true));
        // thread2에 대한 호출, 지연 없음
        Thread thread2 = new Thread(() -> example.performTask(false));

        thread1.start();
        thread2.start();
    }

}
