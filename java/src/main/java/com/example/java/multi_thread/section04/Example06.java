package com.example.java.multi_thread.section04;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Example06 {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));
        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {

        private final Queue<String> queue;

        public Producer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    produceData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void produceData() throws InterruptedException {
            lock.lock();
            if (queue.size() == 10) {
                log.info("In Producer, waiting...");
                condition.await();
            }
            Thread.sleep(1000);
            log.info("Producing data with id {}", queue.size());
            queue.add("element_" + queue.size());
            if (queue.size() == 1) {
                condition.signal();
            }
            lock.unlock();
        }


    }

    static class Consumer implements Runnable {

        private final Queue<String> queue;

        public Consumer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consumeData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consumeData() throws InterruptedException {
            lock.lock();
            if (queue.isEmpty()) {
                log.info("Consumer is waiting...");
                condition.await();
            }
            Thread.sleep(700);
            String data = queue.remove();
            log.info("Consumed data : {}", data);
            if (queue.size() == 9) {
                condition.signal();
            }
            lock.unlock();
        }

    }

}
