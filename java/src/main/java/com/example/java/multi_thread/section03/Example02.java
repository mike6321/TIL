package com.example.java.multi_thread.section03;

public class Example02 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("[1] current thread : " + Thread.currentThread().getName());
        Thread thread = new Thread(
                () -> System.out.println("[2] current thread : " + Thread.currentThread().getName())
        );
        thread.setName("MyThread");
        thread.start();
        thread.join();
        System.out.println("[3] current thread : " + Thread.currentThread().getName());
        System.out.println("MyThread isAlive : " + thread.isAlive()); // join 이 되면 thread 가 죽는다.
    }

}
