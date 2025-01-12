package com.example.java.concurrent.chapter02.example02;

public class SingleThreadTerminatedExample {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0 ; i < 1000; i++) {
            sum += i;
        }
        System.out.println("sum: " + sum);
        System.out.println("main thread terminated");
    }

}
