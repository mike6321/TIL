package com.example.java.concurrent.chapter02.example03;

public class e_BlockedStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true)  {

                    }
                }
            }
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("Thread02 acquired lock");
                }
            }
        });

        thread01.start();
        Thread.sleep(100);
        thread02.start();
        Thread.sleep(100);

        System.out.println("Thread(thread01) state: " + thread01.getState());
        System.out.println("Thread(thread02) state: " + thread02.getState());

    }

}
