package com.example.java.concurrent.chapter02.example02;

public class ThreadRunStartExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run");
            }
        });

        thread.start();
        // run 을 수행하면 새로운 스레드가 생성되지 않고 현재 스레드에서 run 메서드를 실행한다.
        thread.run();
    }

}
