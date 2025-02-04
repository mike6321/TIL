package com.example.java.concurrent.chapter04.example01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultExceptionHandlerExample {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.error("예외가 발생했습니다. 스레드: {}, 메시지: {}", t.getName(), e.getMessage());
            }
        });

        Thread tread01 = new Thread(() -> {
            throw new RuntimeException("스레드 예외 발생");
        });

        Thread tread02 = new Thread(() -> {
            throw new RuntimeException("스레드 예외 발생");
        });

        tread01.start();
        tread02.start();
    }

}
