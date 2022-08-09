package com.example.java.multi_thread.section05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;

@Slf4j
public class Example04 {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread thread = new Thread(() -> {
            try {
                String receivedValue = exchanger.exchange("value1");
                log.info("Received : {}", receivedValue);
            } catch (InterruptedException e) {

            }
        });
        thread.start();

        String receivedValue = exchanger.exchange("value2");
        log.info("Received : {}", receivedValue);
    }

}
