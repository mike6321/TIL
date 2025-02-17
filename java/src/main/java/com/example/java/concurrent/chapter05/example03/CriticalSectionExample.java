package com.example.java.concurrent.chapter05.example03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CriticalSectionExample {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread01 = new Thread(sharedResource::increment);
        Thread thread02 = new Thread(sharedResource::increment);

        thread01.start();
        thread02.start();
    }

    static class SharedResource {
        private int count = 0;

        public void increment() {
            synchronized (this) {
                for (int i = 0; i < 100000; i++) {
                    count++;
                    log.info("{}: {}", Thread.currentThread().getName(), count);
                }
            }

            this.doOtherWork();
        }

        public void doOtherWork() {
            log.info("{}: 다른 작업을 합니다.", Thread.currentThread().getName());
        }
    }

}
