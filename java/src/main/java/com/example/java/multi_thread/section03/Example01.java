package com.example.java.multi_thread.section03;

import java.util.Set;

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
     * current thread : MyThread
     * Common-Cleaner : TIMED_WAITING
     * Finalizer : WAITING
     * Monitor Ctrl-Break : RUNNABLE
     * Signal Dispatcher : RUNNABLE
     * MyThread : TERMINATED
     * main : RUNNABLE
     * Reference Handler : RUNNABLE
     *
     * current thread : main
     * Signal Dispatcher : RUNNABLE
     * Common-Cleaner : TIMED_WAITING
     * Monitor Ctrl-Break : RUNNABLE
     * Reference Handler : RUNNABLE
     * Finalizer : WAITING
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
