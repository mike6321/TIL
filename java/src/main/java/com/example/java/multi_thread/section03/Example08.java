package com.example.java.multi_thread.section03;

import java.util.ArrayList;
import java.util.List;

public class Example08 {

    private static int globalCounter = 0; // heap memory
//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
//    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "initialValue");

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("threadGroup-01");
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(threadGroup, new MyThread());
            thread.start();
            threads.add(thread);
        }

        threadGroup.interrupt();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Total = " + globalCounter);
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }

            globalCounter++;

//            threadLocal.set("myValue");
//            threadLocal.get();

//            int localCounter = 0; // stack memory
//            localCounter = globalCounter;
//            localCounter = localCounter + 1;
//            globalCounter = localCounter;
        }

    }

}
