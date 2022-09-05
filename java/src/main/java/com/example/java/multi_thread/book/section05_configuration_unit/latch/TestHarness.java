package com.example.java.multi_thread.book.section05_configuration_unit.latch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1); // 시작관문
        final CountDownLatch endGate = new CountDownLatch(nThreads); // 종료관문

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    log.info("startGate before await");
                    startGate.await();
                    try {
                        log.info("startGate after await :: {}", startGate.getCount());
                        task.run();
                    } finally {
                        log.info("endGate before countDown :: {}", endGate.getCount());
                        endGate.countDown();
                        log.info("endGate after countDown :: {}", endGate.getCount());
                    }
                } catch (InterruptedException e) {

                }
            });
            thread.start();
        }
        long start = System.nanoTime();
        log.info("startGate before countDown :: {}", startGate.getCount());
        startGate.countDown();
        log.info("startGate after countDown :: {}", startGate.getCount());
        endGate.await();
        long end = System.nanoTime();
        long duration = end - start;
        log.info("duration : {}", duration);
        return duration;
    }

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        testHarness.timeTasks(3, () -> log.info("timeTasks"));
    }

}
