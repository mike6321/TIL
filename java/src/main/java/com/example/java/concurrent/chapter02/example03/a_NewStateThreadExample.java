package com.example.java.concurrent.chapter02.example03;

public class a_NewStateThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 실행 중");
            }
        });

        System.out.println("Thread state: " + thread.getState());
    }

}
