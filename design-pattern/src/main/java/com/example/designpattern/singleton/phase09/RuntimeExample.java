package com.example.designpattern.singleton.phase09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RuntimeExample {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String hello1 = applicationContext.getBean("hello", String.class);
        String hello2 = applicationContext.getBean("hello", String.class);

        if (hello1 == hello2) {
            System.out.println("true");
        }
    }

}
