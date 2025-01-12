package com.example.java.concurrent.chapter02.example03;

public class b_RunnableStateThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 1000; i++) {
                        if (i % 1000 == 0) {
                            System.out.println("Thread State: " + Thread.currentThread().getState());
                        }
                    }
                }
            }
        });

        System.out.println("Thread state: " + thread.getState());
        thread.start();
    }

}
