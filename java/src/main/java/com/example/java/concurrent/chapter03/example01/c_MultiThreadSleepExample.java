package com.example.java.concurrent.chapter03.example01;

public class c_MultiThreadSleepExample {

    public static void main(String[] args) {
        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Sleeping for 1 seconds");
                    Thread.sleep(1000);
                    System.out.println("Done thread01 sleeping");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Sleeping for 2 seconds");
                    Thread.sleep(2000);
                    System.out.println("Done thread02 sleeping");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread01.start();
        thread02.start();
    }

}
