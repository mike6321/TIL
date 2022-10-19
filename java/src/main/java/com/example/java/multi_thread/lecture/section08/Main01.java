package com.example.java.multi_thread.lecture.section08;

import java.util.concurrent.Semaphore;

/**
 * 소비자의 세마포어의 허용개수는 0개 이다.
 * 그렇기 때문에 release 를 해주지 않는 이상 블로킹된다.
 *
 * 생산자는 1개의 스레드로 계속 작업을 진행한다.
 * 그때마다 소비자에게 release 를 하게되는데
 *
 * release 요청이 올때마다 소비자는 블로킹을 풀고 작업을 진행하게되므로
 * 소비자가 생상자보다 많을 경우는 발생하지 않는다.
 *
 * 소비자 <- release(), release(), release(),
 * */
public class Main01 {

    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
    }

    public static class Q {

        private int item;
        private static final Semaphore consumerSemaphore = new Semaphore(0);
        private static final Semaphore producerSemaphore = new Semaphore(3);

        public void get() {
            try {
                consumerSemaphore.acquire(); // block
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Consumer consumed item : " + item);
            producerSemaphore.release();
        }

        public void put(int item) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.item = item;

            System.out.println("Producer produced item : " + item);

            consumerSemaphore.release();
        }

    }

    public static class Producer implements Runnable {

        private final Q q;

        public Producer(Q q) {
            this.q = q;
            new Thread(this, "Producer").start();
        }

        @Override
        public void run() {
            for (int i = 0; i < THREAD_COUNT; i++) {
                q.put(i);
            }
        }

    }

    public static class Consumer implements Runnable {

        private final Q q;

        public Consumer(Q q) {
            this.q = q;
            new Thread(this, "Consumer").start();
        }

        @Override
        public void run() {
            for (int i = 0; i < THREAD_COUNT; i++) {
                q.get();
            }
        }

    }

}
