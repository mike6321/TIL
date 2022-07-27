package com.example.java.multi_thread.section04;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Example04 {

    private static int S = 0;
    private static int[] array = new int[10];
    private static Lock lockObject = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            array[i] = 10;
        }
        List<Thread> threads = new ArrayList<>();
        int threadSlice = array.length / 2;
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new WorkerThread(i * threadSlice, (i + 1) * threadSlice));
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("The sum is : {}", S);
    }

    static class WorkerThread implements Runnable {

        private final int left;
        private final int right;

        public WorkerThread(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            for (int i = left; i < right; i++) {
                lockObject.lock();
                S = S + array[i];
                lockObject.unlock();
            }
        }

    }

}
