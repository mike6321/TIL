package com.example.java.multi_thread.section05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class Example01 {

    private static int foundPosition = 0;
    private static int numberOfThreads = 2;
    private static int numberToSearch = 5;
    private static int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    private static CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

    public static void main(String[] args) throws InterruptedException {
        int threadSlice = array.length / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new WorkerThread((i * threadSlice), (i + 1) * threadSlice));
            thread.start();
            System.out.println("1");
        }
        /**
         * await 를 하지 않으면 바로 통과해 버려서
         * foundPosition 은 설정된 값이 없기 때문에 0 이된다.
         * */
        countDownLatch.await();
        System.out.println("3");
        log.info("The number was found on position : " + foundPosition);
    }

    static class WorkerThread implements Runnable {

        private final int left;
        private final int right;

        public WorkerThread(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            log.info("left : {}, right : {}", left, right);
            for (int i = left; i < right; i++) {
                if (array[i] == numberToSearch) {
                    foundPosition = i;
                    System.out.println("2");
                    log.info("foundPosition : {}", i);
                }
            }
            /**
             * countDown 를 하지 않으면 종료되지 않는다.
             * */
            countDownLatch.countDown();
        }

    }

}
