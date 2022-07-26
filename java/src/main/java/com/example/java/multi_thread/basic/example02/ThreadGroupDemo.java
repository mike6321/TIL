package com.example.java.multi_thread.basic.example02;

public class ThreadGroupDemo {

    public static void main(String args[]) throws Exception {

        ThreadGroup group = new ThreadGroup("new Group");

        NewThread t1 = new NewThread(group, "Thread1");
        NewThread t2 = new NewThread(group, "Thread2");

        // this will call run() method
        t1.start();
        t2.start();

        Thread.sleep(1000);

        // it shows current active threads in Thread Group
        System.out.println(group.activeCount() + " threads in thread group...");

        // returns the number of thread groups
        Thread th[] = new Thread[group.activeCount()];
        group.enumerate(th);
        for(Thread t : th) {
            System.out.println(t.getName());
        }

        t1.stopFunc();
        Thread.sleep(1000);

        System.out.println(group.activeCount() + " threads in thread group...");
        // thread group interrupted
        group.interrupt();
    }
}
