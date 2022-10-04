package com.example.java.multi_thread.lecture.section02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentional Exception.");
            }
        });

        thread.setName("Misbehaving thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                + " the error is " + e.getMessage());
            }
        });

        thread.start();
    }

}
