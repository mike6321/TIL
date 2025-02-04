package com.example.java.concurrent.chapter04.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserAndDaemonInheritanceExample {

    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            new Thread(() -> {
                log.info("사용자 스레드의 자식 스레드의 데몬 상태: {}", Thread.currentThread().isDaemon());
            }).start();
            log.info("사용자 스레드의 데몬 상태: {}", Thread.currentThread().isDaemon());
        });

        Thread daemonThread = new Thread(() -> {
            new Thread(() -> {
                log.info("데몬 스레드의 자식 스레드의 데몬 상태: {}", Thread.currentThread().isDaemon());
            }).start();
            log.info("데몬 스레드의 데몬 상태: {}", Thread.currentThread().isDaemon());
        });

        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();
    }

}
