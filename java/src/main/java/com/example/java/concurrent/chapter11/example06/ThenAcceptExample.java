package com.example.java.concurrent.chapter11.example06;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class ThenAcceptExample {

    public static void main(String[] args) {
        MyService myService = new MyService();
        CompletableFuture.supplyAsync(() -> {
            log.info("thread1: {}", Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 40;
        })
        /**
         * @see CompletableFuture.UniAccept#tryFire(int)
         * @see CompletableFuture#completeNull()
         * */
        .thenAccept(result -> {
            log.info("thread2: {}", Thread.currentThread().getName());
            log.info("result: {}", result);
            List<Integer> r = myService.getData1();
            r.forEach(System.out::println);
        }).thenAcceptAsync(result -> {
            log.info("thread3: {}", Thread.currentThread().getName());
            log.info("result: {}", result);
            List<Integer> r = myService.getData1();
            r.forEach(System.out::println);
        }).join();
    }

    static class MyService {

        public List<Integer> getData1(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(1,2,3);
        }

        public List<Integer> getData2(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(4,5,6);
        }
    }

}
