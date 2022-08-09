package com.example.java.multi_thread.section05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Phaser;

@Slf4j
public class Example03 {

    private static int S = 0;
    private static int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    private static Phaser phaser = new Phaser(1);

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            Thread thread = new Thread(new WorkThread(i));
            thread.start();
        }
        phaser.arriveAndAwaitAdvance(); // await mainThread 동기화 (1)
        System.out.println("main (1)");
        phaser.arriveAndAwaitAdvance(); // await mainThread 동기화 (2)
        System.out.println("main (2)");

        log.info("The sum is : {}", S);
        log.info("Phase count : {}", phaser.getPhase());
    }

    static class WorkThread implements Runnable {

        private final int threadIndex;

        public WorkThread(int threadIndex) {
            this.threadIndex = threadIndex;
            phaser.register(); // Phaser 의 parties 1 증가
        }

        @Override
        public void run() {
            array[threadIndex] = array[threadIndex] * 2; // calculate double
            phaser.arriveAndAwaitAdvance(); // await mainThread 동기화 (1)
            System.out.println("sub (1)");
            if (threadIndex == 0) {
                for (int j = 0; j < array.length; j++) {
                    S = S + array[j];  // await
                }
                phaser.arriveAndAwaitAdvance(); // await mainThread 동기화 (2)
                System.out.println("sub (2)");
            } else {
                phaser.arriveAndDeregister();
            }
        }

    }

}
