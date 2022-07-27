package com.example.java.multi_thread.section04;

import java.util.ArrayList;
import java.util.List;

public class Example01 {

    private static int globalCounter = 0;
    private static final Object obj = new Object();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("threadGroup-01");
        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(threadGroup, new MyThread());
            thread.start();
            threads.add(thread);
        }
        quitThreadGroup(threads, threadGroup);
        System.out.println("Total = " + globalCounter);
    }

    private static void quitThreadGroup(List<Thread> threads, ThreadGroup threadGroup) {
        threadGroup.interrupt();
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            // 한번에 하나의 쓰레드만 입장가능
            synchronized (obj) {
                globalCounter++;
            }
        }

    }

    private synchronized void increment01() {
        synchronized (this) {

        }
    }

    private static synchronized void increment02() {
        synchronized (MyThread.class) {

        }
    }

}
