package com.example.java.multi_thread.lecture.section09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 35,597,152 operation were performed in 10 seconds
 * */
public class Example01SynchronizedStack {

    public static void main(String[] args) throws InterruptedException {
        StandardStack<Integer> standardStack = new StandardStack<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            standardStack.push(random.nextInt());
        }

        List<Thread> threads = new ArrayList<>();

        int pushingThread = 2;
        int poppingThread = 2;

        for (int i = 0; i < pushingThread; i++) {
            Thread thread = new Thread(() -> {
               while (true) {
                   standardStack.push(random.nextInt());

               }
            });

            thread.setDaemon(true);
            threads.add(thread);
        }

        for (int i = 0; i < poppingThread; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    standardStack.push(random.nextInt());

                }
            });

            thread.setDaemon(true);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(10000);

        System.out.println(String.format("%,d operation were performed in 10 seconds ", standardStack.getCounter()));
    }

    public static class StandardStack<T> {
        private StackNode<T> head;
        private int counter = 0;

        public synchronized void push(T value) {
            StackNode<T> newHead = new StackNode<>(value);
            /********* race condition *********/
            newHead.next = head;
            head = newHead;
            counter++;
            /********* race condition *********/
        }

        public synchronized T pop() {
            if (head == null) {
                counter++;
                return null;
            }

            /********* race condition *********/
            T value = head.value;
            head = head.next;
            counter++;
            /********* race condition *********/
            return value;
        }

        public int getCounter() {
            return counter;
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
