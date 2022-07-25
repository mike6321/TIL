package com.example.java.multi_thread.section03;

import java.util.List;

public class Example07 {

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = step01();
//        Thread thread = step02();
        Thread thread = step03();

        thread.start();
        thread.join();
    }

    private static Thread step03() {
        Thread thread = new Thread(new MyThread(1), "thread-01");
        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println(e.getMessage());
        });
        return thread;
    }

    private static Thread step02() {
        Thread thread = new Thread(new MyThread(1), "thread-01");
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println(e.getMessage());
        });
        return thread;
    }

    private static Thread step01() {
        return new Thread(new CustomThreadGroup("threadGroup-01"), new MyThread(1), "thread-01");
    }

    static class CustomThreadGroup extends ThreadGroup {

        public CustomThreadGroup(String name) {
            super(name);
        }

        public CustomThreadGroup(ThreadGroup parent, String name) {
            super(parent, name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            super.uncaughtException(t, e);
            System.out.println(e.getMessage());
        }
    }

    static class MyThread implements Runnable {

        private final int numberOfSeconds;

        public MyThread(int numberOfSeconds) {
            this.numberOfSeconds = numberOfSeconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.numberOfSeconds; i++) {
                System.out.println("Sleeping for 1s, Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            List<String> list = null;
            list.size();
        }

    }

}
