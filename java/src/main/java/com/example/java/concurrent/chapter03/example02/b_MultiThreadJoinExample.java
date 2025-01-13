package com.example.java.concurrent.chapter03.example02;

public class b_MultiThreadJoinExample {

    public static void main(String[] args) throws InterruptedException {

        Thread thread01 = new Thread(() -> {
            try {
                System.out.println("thread01 가 3초 동안 작동합니다.");
                Thread.sleep(3000);
                System.out.println("thread01 작동 완료.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread02 = new Thread(() -> {
            try {
                System.out.println("thread02 가 2초 동안 작동합니다.");
                Thread.sleep(2000);
                System.out.println("thread02 작동 완료.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread01.start();
        thread02.start();

        System.out.println("메인 스레드가 다른 스레드의 완료를 기다립니다.");

        thread01.join();
        thread02.join();

        System.out.println("메인 스레드가 계속 진행합니다");
    }

}
