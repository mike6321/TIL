package com.example.java.multi_thread.lecture.section03;

import java.math.BigInteger;

public class Main03 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("1000000000")));
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
    }

    private static class LongComputationTask implements Runnable {

        private final BigInteger base;
        private final BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ONE; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            return result;
        }

    }

}
