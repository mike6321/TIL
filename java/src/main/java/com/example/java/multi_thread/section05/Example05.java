package com.example.java.multi_thread.section05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Example05 {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // step01
//        Thread thread01 = new Thread(() -> {
//            lock1.lock();
//            log.info("Thread 01 acquired lock1");
//            lock2.lock();
//            log.info("Thread 01 acquired lock2");
//
//            lock2.unlock();
//            lock1.unlock();
//        });
//        Thread thread02 = new Thread(() -> {
//            lock2.lock();
//            log.info("Thread 02 acquired lock2");
//            lock1.lock();
//            log.info("Thread 02 acquired lock1");
//
//            lock1.unlock();
//            lock2.unlock();
//        });

        // step02
        Thread thread01 = new Thread(() -> {
            lock2.lock();
            log.info("Thread 01 acquired lock2");
            lock1.lock();
            log.info("Thread 01 acquired lock1");

            lock1.unlock();
            log.info("Thread 01 acquired unlock1");
            lock2.unlock();
            log.info("Thread 01 acquired unlock2");
        });
        Thread thread02 = new Thread(() -> {
            lock2.lock();
            log.info("Thread 02 acquired lock2");
            lock1.lock();
            log.info("Thread 02 acquired lock1");

            lock1.unlock();
            log.info("Thread 02 acquired unlock1");
            lock2.unlock();
            log.info("Thread 02 acquired unlock2");
        });
        thread01.start();
        thread02.start();
    }

}
