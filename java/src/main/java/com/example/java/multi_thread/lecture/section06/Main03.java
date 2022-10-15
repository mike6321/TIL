package com.example.java.multi_thread.lecture.section06;

import java.util.Random;

public class Main03 {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogic businessLogicThread01 = new BusinessLogic(metrics);
        BusinessLogic businessLogicThread02 = new BusinessLogic(metrics);
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);

        businessLogicThread01.start();
        businessLogicThread02.start();
        metricsPrinter.start();
    }

    public static class MetricsPrinter extends Thread {

        private final Metrics metrics;

        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                double currentAverage = metrics.getAverage();
                System.out.println("currentAverage = " + currentAverage);
            }
        }

    }

    public static class BusinessLogic extends Thread {

        private final Metrics metrics;
        private final Random random = new Random();

        public BusinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {

            while (true) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {

                }
                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }

        }

    }

    public static class Metrics {

        private long count = 0;
        private volatile double average = 0.0;

        public synchronized void addSample(long sample) {
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) /count;
        }

        public double getAverage() {
            return this.average;
        }

    }

}
