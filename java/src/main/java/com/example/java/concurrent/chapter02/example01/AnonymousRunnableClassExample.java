package com.example.java.concurrent.chapter02.example01;

public class AnonymousRunnableClassExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중...");
            }
        });

        thread.start();
    }


}
