package com.example.java.multi_thread.section04;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example02 {

    private static final Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        // Thread 1
        synchronized (obj) {
            obj.wait(); // notify 를 한다고 해서 바로 unlock 상태로 변하진 않는다.
            log.info("Next Instructions");
        }

        // Thread 2
        synchronized (obj) {
            obj.notify();
            log.info("Next Instructions");
        }

    }
}
