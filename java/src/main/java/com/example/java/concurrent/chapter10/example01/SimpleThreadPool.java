package com.example.java.concurrent.chapter10.example01;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleThreadPool {

    private final int numThreads;
    private final Queue<Runnable> taskQueue;
    private final Thread[] threads;
    private volatile boolean isShutdown;

    public SimpleThreadPool(int numThreads) {
        this.numThreads = numThreads;
        this.taskQueue = new LinkedList<>();
        this.threads = new Thread[numThreads];
        this.isShutdown = false;

        for (int i = 0; i < numThreads; i++) {
            this.threads[i] = new WokerThread();
            this.threads[i].start();
        }
    }

    public void submit(Runnable task) {
        if (!this.isShutdown)  {
            synchronized (taskQueue) {
                taskQueue.offer(task);
                taskQueue.notifyAll();
            }
        }
    }

    public void shutdown() {
        this.isShutdown = true;
        synchronized (taskQueue) {
            this.taskQueue.notifyAll();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    class WokerThread extends Thread {
        @Override
        public void run() {
            while (!isShutdown) {
                Runnable task;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (!taskQueue.isEmpty()) {
                        task = taskQueue.poll();
                    } else {
                        continue;
                    }
                    task.run();
                }
            }
        }
    }

}
