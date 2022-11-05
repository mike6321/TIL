package com.example.java.multi_thread.lecture.section09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * 101,099,717 operation were performed in 10 seconds
 * */
public class Example02LockFreeStack {

    public static void main(String[] args) throws InterruptedException {
        LockFreeStack<Integer> lockFreeStack = new LockFreeStack<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            lockFreeStack.push(random.nextInt());
        }

        List<Thread> threads = new ArrayList<>();

        int pushingThread = 2;
        int poppingThread = 2;

        for (int i = 0; i < pushingThread; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    lockFreeStack.push(random.nextInt());

                }
            });

            thread.setDaemon(true);
            threads.add(thread);
        }

        for (int i = 0; i < poppingThread; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    lockFreeStack.push(random.nextInt());
                }
            });

            thread.setDaemon(true);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(10000);

        System.out.println(String.format("%,d operation were performed in 10 seconds ", lockFreeStack.counter.get()));
    }

    public static class LockFreeStack<T> {
        private AtomicReference<StackNode<T>> head = new AtomicReference<>();
        private AtomicInteger counter = new AtomicInteger(0);

        public void push(T value) {
            StackNode<T> newHead = new StackNode<>(value);

            // 많은 스레드가 동시에 스택으로 항목을 푸시하거나 팝 하기 때문에 loop 사용
            while (true) {
                StackNode<T> currentHead = head.get();
                newHead = currentHead;
                if (head.compareAndSet(currentHead, newHead)) {
                    break;
                } else { // 연산 사이에 헤드가 변경 됨
                    LockSupport.parkNanos(1); // 연산을 다시하기전 1 nano 대기
                }
            }
            counter.incrementAndGet();
        }

        public T pop() {
            StackNode<T> currentHead = head.get();
            StackNode<T> newHead;

            while (currentHead != null) {
                newHead = currentHead.next;
                if (head.compareAndSet(currentHead, newHead)) {
                    break;
                } else {
                    LockSupport.parkNanos(1);
                    currentHead = head.get();
                }
            }
            counter.incrementAndGet();
            return currentHead != null ? currentHead.value : null;
        }

        public int getCounter() {
            return counter.get();
        }
    }


    private static class StackNode<T> {
        public final T value;
        public StackNode<T> next;

        public StackNode(T value) {
            this.value = value;
            this.next = next;
        }
    }

}
