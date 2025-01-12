package com.example.java.concurrent.chapter03.example01;

public class b_LoopSleepExample {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Sleeping for 2 seconds");
                Thread.sleep(2000);
                System.out.println("Done sleeping");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
