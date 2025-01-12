package com.example.java.concurrent.chapter02.example03;

public class c_WaitingStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(1000l);
        System.out.println("Thread state: " + thread.getState());

    }

}
