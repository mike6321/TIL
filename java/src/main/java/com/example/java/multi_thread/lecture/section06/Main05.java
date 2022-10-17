package com.example.java.multi_thread.lecture.section06;

import java.util.Random;

public class Main05 {

    public static void main(String[] args) throws InterruptedException {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        Thread.sleep(15);
        trainBThread.start();
    }

    public static class TrainA implements Runnable {

        private final Intersection intersection;
        private final Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while (true) {
                long sleepingTime= random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                } catch (InterruptedException e) {

                }
                intersection.takeRoadA();
            }
        }

    }

    public static class TrainB implements Runnable {

        private final Intersection intersection;
        private final Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while (true) {
                long sleepingTime= random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                } catch (InterruptedException e) {

                }
                intersection.takeRoadB();
            }
        }

    }

    /**
     * Road A is locked by thread Thread-0
     * Road B is locked by thread Thread-1
     *
     * 각각의 Thread 가 RoadA, RoadB 에 대한 락을 획득하고 있는 상황에서
     * 서로의 락을 원할 경우 데드락 발생
     * */

    public static class Intersection {
        private final Object roadA = new Object();
        private final Object roadB = new Object();

        public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road A...");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }

        public void takeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());
                synchronized (roadA) {
                    System.out.println("Train is passing through road B...");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }

    }

}
