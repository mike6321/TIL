package com.example.java.multi_thread.section03;

public class Example05 {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");
        Thread thread01 = new Thread(group, new MyThread(), "thread-01");
        Thread thread02 = new Thread(group, new MyThread(), "thread-02");
        Thread thread03 = new Thread(group, new MyThread(), "thread-03");

        ThreadGroup parent = group.getParent();
        System.out.println("parent name : " + parent.getName() + " priority : " + parent.getMaxPriority());

        thread03.setPriority(Thread.MAX_PRIORITY);
        thread01.start();
        thread02.start();
        thread03.start();

        System.out.println("sleeping for 3 seconds...");
        Thread.sleep(3000);

        group.interrupt();
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
//                    System.out.println("running!");
                } catch (InterruptedException e) {
                    Thread currentThread = Thread.currentThread();
                    System.out.println("name : " + currentThread.getName() + " priority : " + currentThread.getPriority());
                }
            }
        }

    }

}
