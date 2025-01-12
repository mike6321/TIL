package com.example.java.concurrent.chapter02.example03;

public class f_TerminatedStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 실행 중");
            }
        });

        thread.start();
        thread.join();

        System.out.println("Thread state: " + thread.getState());
    }

}
