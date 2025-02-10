package com.example.java.concurrent.chapter04.example05;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InheritableThreadLocalExample {

    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("부모 스레드의 값");
        new Thread(() -> {
            System.out.println("자식 스레드에서 부모 스레드의 값을 참조: " + inheritableThreadLocal.get());
        }).start();
    }

}
