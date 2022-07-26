package com.example.java.multi_thread.basic.example02;

public class NewThread extends Thread {
    boolean stop;

    NewThread(ThreadGroup group, String name) {
        super(group, name);
        stop = false;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        try {
            for(int i = 1; i < 1000; i++) {
                Thread.sleep(500);
                synchronized(this) {
                    if(stop)
                        break;
                }
            }
        } catch(Exception e) {
            System.out.print(Thread.currentThread().getName());
            System.out.println(" interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " exiting.");
    }

    synchronized void stopFunc() {
        stop = true;
    }
}
