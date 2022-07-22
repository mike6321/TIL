package com.example.java.multi_thread.section03;

public class Example01 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();
    }

    static class MyThread extends Thread {

        public void run() {
            setName("MyThread");
            Thread thread = Thread.currentThread();
            System.out.println("current thread : " + thread.getName());
        }

    }

}
