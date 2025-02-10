package com.example.java.concurrent.chapter05.example01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleThreadExample {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
            try {
                Thread.sleep(1);
//                throw new RuntimeException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("sum: {}", sum);
        log.info("실행 시간: {}", System.currentTimeMillis() - start);
    }

}
