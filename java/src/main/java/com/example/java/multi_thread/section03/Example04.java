package com.example.java.multi_thread.section03;

public class Example04 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println("[1] state : " + currentThread.getState());
            }
        );

        System.out.println("[2] state : " + thread01.getState());

        thread01.start();
        System.out.println("[3] state : " + thread01.getState());

        thread01.join();
        System.out.println("[4] state : " + thread01.getState());
    }

}
