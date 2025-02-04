package com.example.java.concurrent.chapter04.example02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlagThreadStopNonVolatileExample {

    private static boolean running = true;

    public static void main(String[] args) {
        new Thread(() -> {
            int count = 0;
           while (running) {
               /**
                * Thread.sleep(1)이 인한 메모리 가시성 보장
                * 	Thread.sleep(1)은 CPU 의 컨텍스트 스위칭을 유발하며, 이는 메모리 가시성(Visibility)을 개선하는 역할을 합니다.
                * 	일반적으로 CPU 캐시는 효율성을 위해 변수 값을 캐싱하여 사용하지만, 스레드가 sleep()을 호출하면 CPU 는 해당 스레드를 일시 정지하고, 다른 스레드를 실행하면서 최신 값을 메모리에서 다시 로드할 가능성이 높아집니다.
                * 	따라서 running 변수가 변경된 후에도 while (running) 조건이 정상적으로 업데이트될 확률이 높아지는 것입니다.
                * */
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
                count++;
           }
           log.info("Thread stopped. count: {}", count);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Thread stopping...");
            running = false;
        }).start();
    }

}
