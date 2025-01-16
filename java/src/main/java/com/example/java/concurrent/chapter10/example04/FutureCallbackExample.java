package com.example.java.concurrent.chapter10.example04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureCallbackExample {

    interface Callback {

        void onComplete(int result);

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> callableTask = () -> {
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> future = executorService.submit(callableTask);
        log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
        registerCallback(future, result -> {
            System.out.println("비동기 작업 완료 후 콜백 호출: " + result);
        });

        executorService.shutdown();

        Integer result = future.get();
        log.info("비동기 작업 결과: {}", result);
    }

    private static void registerCallback(Future<Integer> future, Callback callback) {
        new Thread(() -> {
            int result = 0;
            try {
                result = future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            callback.onComplete(result);
        });

    }

}
