package com.example.java.concurrent.chapter04.example05.logger;

public class ThreadLocalLoggerExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new LogWorker(), "THREAD-1");
        Thread thread2 = new Thread(new LogWorker(), "THREAD-2");
        Thread thread3 = new Thread(new LogWorker(), "THREAD-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

}
