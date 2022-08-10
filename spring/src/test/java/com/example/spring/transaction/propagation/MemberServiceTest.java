package com.example.spring.transaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
class MemberServiceTest {
    
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private LogRepository logRepository;

    /**
     * memberService    @Transaction : OFF
     * memberRepository @Transaction : ON
     * logRepository    @Transaction : ON
     * */
    @Order(1)
    @DisplayName("트랜잭션 전파 활용2 - 커밋")
    @Test
    void outerTxOff_success() {
        // given
        String username = "outerTxOff_success";
        // when
        memberService.joinV1(username);
        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transaction : OFF
     * memberRepository @Transaction : ON
     * logRepository    @Transaction : ON Exception
     * */
    @Order(2)
    @DisplayName("트랜잭션 전파 활용2 - 롤백")
    @Test
    void outerTxOff_fail() {
        // given
        String username = "로그예외_outerTxOff_fail";
        // when
        assertThrows(
                RuntimeException.class,
                () -> memberService.joinV1(username)
        );
        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertFalse(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transaction : ON
     * memberRepository @Transaction : OFF
     * logRepository    @Transaction : OFF
     * */
    @Order(3)
    @DisplayName("트랜잭션 전파 활용3 - 단일 트랜잭션")
    @Test
    void singleTx() {
        // given
        String username = "outerTxOff_success";
        // when
        memberService.joinV2(username);
        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transaction : ON
     * memberRepository @Transaction : ON
     * logRepository    @Transaction : ON
     * */
    @Order(4)
    @DisplayName("트랜잭션 전파 활용3 - 단일 트랜잭션")
    @Test
    void outerTxOn_success() {
        // given
        String username = "outerTxOn_success";
        // when
        memberService.joinV2(username);
        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

}
