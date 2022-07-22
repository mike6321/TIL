package com.example.java.multi_thread.section03;

public class Example03 {

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Thread thread01 = new Thread(() -> {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread.getName() + " priority : " + currentThread.getPriority());
            }
        );
        thread01.setPriority(Thread.MAX_PRIORITY);
        thread01.setName("thread_01");

        Thread thread02 = new Thread(() -> {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread.getName() + " priority : " + currentThread.getPriority());
            }
        );
        thread02.setPriority(Thread.MIN_PRIORITY);
        thread02.setName("thread_02");

        thread01.start();
        thread02.start();
    }

}
