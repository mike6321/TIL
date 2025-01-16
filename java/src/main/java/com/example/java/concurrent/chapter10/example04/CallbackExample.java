package com.example.java.concurrent.chapter10.example04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CallbackExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int result = 42;

            Callback callback = new MyCallback();
            callback.onComplete(result);
        });
        log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
    }

    interface Callback {
        void onComplete(int result);
    }

    static class MyCallback implements Callback {
        @Override
        public void onComplete(int result) {
            log.info("비동기 작업 완료 후 콜백 호출: {}", result);
        }
    }

}
