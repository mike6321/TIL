package com.example.java.multi_thread.lecture.section02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main01 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("We are now in thread " + Thread.currentThread().getName());
            System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + "before starting a new thead");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + "after starting a new thead");
    }

}
