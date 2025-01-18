package com.example.java.concurrent.chapter10.example05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureCancelExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> callableTask = () -> {
            log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.warn("비동기 작업이 중단되었습니다.");
            }
            log.info("비동기 작업 요청 후 메인 스레드 작업 완료");
            return 40;
        };

        Future<Integer> future = executorService.submit(callableTask);
        Thread.sleep(1000);
        /**
         * @param mayInterruptIfRunning true 이면 현재 작업을 수행 중인 스레드를 중단하도록 요청하며, 그렇지 않으면 진행 중인 작업이 완료될 수 있습니다.
         * @param mayInterruptIfRunning false 이면 현재 작업을 수행 중인 스레드를 중단하지 않습니다.
         *
         * @see java.util.concurrent.FutureTask#cancel(boolean)
         * */
        future.cancel(true);
//        future.cancel(false);

        /**
         * @see java.util.concurrent.FutureTask#report(int)
         * */
        Integer result = future.get();
        log.info("비동기 작업 결과: {}", result);

        executorService.shutdown();
    }

}
