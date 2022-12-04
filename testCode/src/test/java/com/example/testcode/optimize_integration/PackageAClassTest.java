package com.example.testcode.optimize_integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

//@SpringBootTest(classes = TestConfig.class)
@SpringBootTest
class PackageAClassTest {


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void register_bean_test() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(System.out::println);

        long count = Arrays.stream(applicationContext.getBeanDefinitionNames())
                .count();
        System.out.println("count = " + count);
        // count = 11
    }


}
