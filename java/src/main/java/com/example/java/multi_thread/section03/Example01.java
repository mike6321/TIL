package com.example.java.multi_thread.section03;

import java.util.Set;

/**
 * Thread Creation
 * */
public class Example01 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        myThread.start();
        myThread.run();
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        threadSet.stream()
                .forEach(thread -> System.out.println(thread.getName() + " : " + thread.getState()));
    }
    /**
     * [start]
     * current thread : MyThread
     * Common-Cleaner : TIMED_WAITING
     * Finalizer : WAITING
     * Monitor Ctrl-Break : RUNNABLE
     * Signal Dispatcher : RUNNABLE
     * Reference Handler : RUNNABLE
     * main : RUNNABLE
     * MyThread : TERMINATED
     *
     * [run]
     * current thread : main
     * Common-Cleaner : TIMED_WAITING
     * Finalizer : WAITING
     * Monitor Ctrl-Break : RUNNABLE
     * Signal Dispatcher : RUNNABLE
     * Reference Handler : RUNNABLE
     * main : RUNNABLE
     * */

    static class MyThread extends Thread {

        public void run() {
            setName("MyThread");
            Thread thread = Thread.currentThread();
            System.out.println("current thread : " + thread.getName());
        }

    }

}
