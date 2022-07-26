package com.example.java.multi_thread.section04;

import java.util.ArrayList;
import java.util.List;

public class Example01 {

    private static int globalCounter = 0;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("group-01");
        for (int i = 0; i <= 1000; i++) {
            Thread thread = new Thread(threadGroup, new MyThread());
            thread.start();
            threads.add(thread);
        }
        threadGroup.interrupt();
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {

        }

    }

}
