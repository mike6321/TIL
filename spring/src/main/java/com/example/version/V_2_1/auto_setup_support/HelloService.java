package com.example.version.V_2_1.auto_setup_support;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Async
    public void hello() {
        System.out.println("hello " + Thread.currentThread().getName());
    }

//    @Scheduled(fixedDelay = 1000 * 2)
    @Scheduled(cron = "0 15 10 15 * ?")
    public void hi() {
        System.out.println("hi " + Thread.currentThread().getName());
    }

}
