package com.example.spring.transaction.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;

@SpringBootTest
public class InitTxTest {

    @Autowired
    private Hello hello;

    @Test
    void go() {
//        hello.initV1();
    }


    @TestConfiguration
    static class InitTxTestConfig {

        @Bean
        public Hello hello() {
            return new Hello();
        }

    }

    @Slf4j
    static class Hello {

        @PostConstruct
        @Transactional
        public void initV1() {
            boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            // PostConstruct 이후에 AOP 적용이 되기 때문에 Transaction 적용 X
            log.info("Hello init @PostConstruct tx active = {}", actualTransactionActive);
        }

        @EventListener(ApplicationReadyEvent.class)
        @Transactional
        public void initV2() {
            boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("Hello init @EventListener tx active = {}", actualTransactionActive);
        }

    }

}
