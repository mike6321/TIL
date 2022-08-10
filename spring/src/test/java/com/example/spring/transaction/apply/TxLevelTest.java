package com.example.spring.transaction.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootTest
public class TxLevelTest {

    @Autowired
    private LevelService levelService;

    @Test
    void orderTest() {
        levelService.write();
        levelService.read();
    }


    @TestConfiguration
    static class TxLevelTestConfig {

        @Bean
        public LevelService levelService() {
            return new LevelService();
        }

    }

    @Slf4j
    @Transactional(readOnly = true)
    static class LevelService {

        @Transactional(readOnly = false)
        public void write() {
            log.info("call write");
            printTransactionInfo();
        }

        public void read() {
            log.info("call read");
            printTransactionInfo();
        }

        private void printTransactionInfo() {
            boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("transaction active = {}", transactionActive);
            boolean currentTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            log.info("transaction readOnly = {}", currentTransactionReadOnly);
        }

    }

}
