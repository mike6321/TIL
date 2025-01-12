package com.example.java.concurrent.chapter03.example01;

public class a_BasicSleepExample {

    public static void main(String[] args) {
        try {
            System.out.println("Sleeping for 2 seconds");
            Thread.sleep(2000);
            System.out.println("Done sleeping");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
