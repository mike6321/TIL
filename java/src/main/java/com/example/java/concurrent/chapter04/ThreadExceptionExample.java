package com.example.java.concurrent.chapter04;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadExceptionExample {

    public static void main(String[] args) {
        // 일반적으로 예외를 외부에서 처리할 수 없다.
        try {
            new Thread(() -> {
                throw new RuntimeException("스레드 예외 발생");
            }).start();
        } catch (RuntimeException e) {
            notify(e);
        }
    }

    private static void notify(RuntimeException e) {
        log.error("예외가 발생했습니다. 메시지: {}", e.getMessage());
    }

}
