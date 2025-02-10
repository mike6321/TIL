package com.example.java.concurrent.chapter04.example05;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalExample {

    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "threadLocalValue");

    public static void main(String[] args) {
        new Thread(() -> {
            log.info("thread01 의 값: {}", threadLocal.get());
            threadLocal.set("thread01Value");
            log.info("thread01 의 값: {}", threadLocal.get());
            threadLocal.remove();
            log.info("thread01 의 값: {}", threadLocal.get());
        }, "thread01").start();

        new Thread(() -> {
            log.info("thread02 의 값: {}", threadLocal.get());
            threadLocal.set("thread02Value");
            log.info("thread02 의 값: {}", threadLocal.get());
        }, "thread02").start();
    }

}
