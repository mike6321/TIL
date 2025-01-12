package com.example.java.concurrent.chapter02.example02;

public class MultiThreadTerminatedExample {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread myThread = new MyThread(i);
            myThread.start();
        }
        System.out.println("main thread terminated");
    }

}
