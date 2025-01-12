package com.example.java.concurrent.chapter02.example02;

public class ThreadStackExample {

    public static void main(String[] args) {
        /**
         * 스레드 스택 별로 독립적인 값을 가진다.
         * */
        for (int i = 0; i < 3; i++) {
            Thread myThread = new MyThread(i);
            myThread.start();
        }
        
    }

}

class MyThread extends Thread {

    private final int threadId;

    MyThread(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  Thread run");
        firstMethod(threadId);
    }

    private void firstMethod(int threadId) {
        int localValue = threadId + 100;
        secondMethod(localValue);
    }

    private void secondMethod(int localValue) {
        System.out.println(Thread.currentThread().getName() + " threadId: " + threadId + ", localValue: " + localValue);
    }

}
