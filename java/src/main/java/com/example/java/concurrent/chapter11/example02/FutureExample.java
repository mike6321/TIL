package com.example.java.concurrent.chapter11.example02;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future01 = executorService.submit(new Service01());
        Future<Integer> future02 = executorService.submit(new Service02(future01));
        Future<Integer> future03 = executorService.submit(new Service03(future02));

        Integer result = future03.get();

        executorService.shutdown();

        log.info("Result: {}", result);
    }

    static class Service01 implements Callable<Integer> {

        @Override
        public Integer call() {
            log.info("Service01 is running");
            return 10;
        }

    }

    @RequiredArgsConstructor
    static class Service02 implements Callable<Integer> {

        private final Future<Integer> future;

        @Override
        public Integer call() throws Exception {
            log.info("Service02 is running");
            return future.get() * 10;
        }

    }

    @RequiredArgsConstructor
    static class Service03 implements Callable<Integer> {

        private final Future<Integer> future;

        @Override
        public Integer call() throws Exception {
            log.info("Service03 is running");
            return future.get() * 10;
        }

    }

}
