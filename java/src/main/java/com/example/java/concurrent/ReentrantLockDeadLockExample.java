package com.example.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDeadLockExample {

    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void method1() {
        lock1.lock();
        try {
            // 다른 작업 수행, 예를 들어 다른 리소스에 접근하는 동안 일부 작업을 수행
            method2();
        } finally {
            lock1.unlock();
        }
    }

    public void method2() {
        lock2.lock();
        try {
            // 다른 작업 수행
            method1();
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDeadLockExample example = new ReentrantLockDeadLockExample();

        new Thread(example::method1).start();
        new Thread(example::method2).start();
    }

}
