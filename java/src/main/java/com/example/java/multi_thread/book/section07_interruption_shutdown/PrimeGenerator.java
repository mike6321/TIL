package com.example.java.multi_thread.book.section07_interruption_shutdown;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class PrimeGenerator implements Runnable {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            log.info("???");
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        exec.execute(generator);
        try {
            SECONDS.sleep(1);
        } finally {
            log.info("cancel");
            generator.cancel();
        }
        log.info("get");
        return generator.get();
    }

    public static void main(String[] args) throws InterruptedException {
        aSecondOfPrimes();
    }

}
