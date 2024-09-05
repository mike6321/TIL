package com.example.distributelock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestATest {

    @Autowired
    private TestA testA;

    @Test
    void test() {
        testA.test();
    }

}