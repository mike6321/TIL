package com.example.java.concurrent.chapter04;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UncaughtExceptionHandlerExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("스레드 예외 발생");
        });

        /**
         * @see Thread#dispatchUncaughtException(Throwable)
         * */
        thread.setUncaughtExceptionHandler((t, e) -> {
            log.warn("예외가 발생했습니다. 스레드: {}, 메시지: {}", t.getName(), e.getMessage());
        });

        thread.start();
    }

}
