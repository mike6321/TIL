package com.example.java.concurrent.chapter02.example03;

public class d_TimeWaitingStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println("Thread state: " + thread.getState());

    }

}
