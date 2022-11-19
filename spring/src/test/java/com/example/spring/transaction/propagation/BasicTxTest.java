package com.example.spring.transaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class BasicTxTest {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @TestConfiguration
    static class Config {
        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }

    @Order(1)
    @DisplayName("스프링 트랜잭션 전파1 - 커밋")
    @Test
    void commit() {
        log.info("트랜잭션 시작");
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션 커밋 시작");
        transactionManager.commit(transactionStatus);
        log.info("트랜잭션 커밋 완료");
    }

    @Order(2)
    @DisplayName("스프링 트랜잭션 전파1 - 롤백")
    @Test
    void rollback() {
        log.info("트랜잭션 시작");
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션 롤백 시작");
        transactionManager.rollback(transactionStatus);
        log.info("트랜잭션 롤백 완료");
    }

    @Order(3)
    @DisplayName("스프링 트랜잭션 전파2 - 트랜잭션 두 번 사용 (커밋)")
    @Test
    void double_commit() {
        log.info("트랜잭션1 시작");
        TransactionStatus tx1 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        transactionManager.commit(tx1);

        log.info("트랜잭션2 시작");
        TransactionStatus tx2 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 커밋");
        transactionManager.commit(tx2);
    }

    @Order(4)
    @DisplayName("스프링 트랜잭션 전파2 - 트랜잭션 두 번 사용 (롤백)")
    @Test
    void double_commit_rollback() {
        log.info("트랜잭션1 시작");
        TransactionStatus tx1 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        transactionManager.commit(tx1);

        log.info("트랜잭션2 시작");
        TransactionStatus tx2 = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 롤백");
        transactionManager.rollback(tx2);
    }

    @Order(5)
    @DisplayName("스프링 트랜잭션 전파4 - 전파 예제")
    @Test
    void inner_commit() {
        /**
         * auto commit false 설정
         * -> to manual commit
         * Participating in existing transaction
         * -> 햔재 존재하는 트랜잭션에 참여
         * innerTx.isNewTransaction = false
         * -> 새로운 트랜션 x
         *
         * "내부 트랜잭션에서는 커밋을 진행하지 않는다."
         *
         * 트랜잭션 내부에서 트랜잭션이 일어날 경우
         * 각각의 논리 트랜잭션이 생기고
         * 전체 트랜잭션을 물리 트랜잭션이라고 한다.
         * 이때 논리 트랜잭션에서 롤백이 생기면 물리 트랜잭션은 전체 롤백이 된다.
         * */
        log.info("외부 트랜잭션 시작");
        TransactionStatus outerTx = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outerTx.isNewTransaction = {}", outerTx.isNewTransaction());

        innerTransaction();

        log.info("외부 트랜잭션 커밋");
        transactionManager.commit(outerTx);
    }

    @Order(6)
    @DisplayName("스프링 트랜잭션 전파5 - 외부 롤백")
    @Test
    void outer_rollback() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outerTx = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outerTx.isNewTransaction = {}", outerTx.isNewTransaction());
        innerTransaction();
        log.info("외부 트랜잭션 커밋");
        transactionManager.rollback(outerTx);
    }

    @Order(7)
    @DisplayName("스프링 트랜잭션 전파6 - 내부 롤백")
    @Test
    void inner_rollback() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outerTx = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outerTx.isNewTransaction = {}", outerTx.isNewTransaction());

        // Participating in existing transaction
        log.info("내부 트랜잭션 시작");
        TransactionStatus innerTx = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("내부 트랜잭션 롤백");
        // Participating transaction failed - marking existing transaction as rollback-only
        /**
         * 신규 트랜잭션이 아니기 때문에 물리 트랜잭션에 대해서 롤백 호출을 하지 않는다.
         * 다만 롤백 마크를 남긴다.
         */
        transactionManager.rollback(innerTx); // marked as rollback-only

        log.info("외부 트랜잭션 커밋");
        assertThatThrownBy(() -> transactionManager.commit(outerTx)).isInstanceOf(UnexpectedRollbackException.class);
        assertThatThrownBy(() -> transactionManager.commit(outerTx)).hasMessage("Transaction is already completed - do not call commit or rollback more than once per transaction");
    }

    @Order(8)
    @DisplayName("스프링 트랜잭션 전파7 - REQUIRES_NEW")
    @Test
    void inner_rollback_required_new() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outerTx = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outerTx.isNewTransaction = {}", outerTx.isNewTransaction());

        innerTransactionWithRequiredNew();

        log.info("외부 트랜잭션 커밋");
        transactionManager.commit(outerTx);
    }

    private void innerTransactionWithRequiredNew() {
        log.info("내부 트랜잭션 시작");
        DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus innerTx = transactionManager.getTransaction(definition);
        log.info("innerTx.isNewTransaction = {}", innerTx.isNewTransaction());
        log.info("내부 트랜잭션 롤백");
        transactionManager.rollback(innerTx); // rollback
    }

    private void innerTransaction() {
        /**
         * Participating in existing transaction
         * innerTx.isNewTransaction = false
         * */
        log.info("내부 트랜잭션 시작");
        TransactionStatus innerTx = transactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("innerTx.isNewTransaction = {}", innerTx.isNewTransaction());
        log.info("내부 트랜잭션 커밋");
        transactionManager.commit(innerTx); // 여기선 아무일도 안한다. (내부 트랜잭션이 외부 트랜잭셔네 참여하기 때문에)
    }

}
