package com.example.spring.transaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

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
        memberService.joinV3(username);
        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transaction : ON
     * memberRepository @Transaction : ON
     * logRepository    @Transaction : ON Exception
     * */
    @Order(5)
    @DisplayName("트랜잭션 전파 활용5 - 전파 롤백")
    @Test
    void outerTxOn_fail() {
        // given
        String username = "로그예외_outerTxOn_fail";
        // when
        assertThrows(
                RuntimeException.class,
                () -> memberService.joinV4(username)
        );
        // then : 모든 데이터가 RollBack
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    @Transaction : ON
     * memberRepository @Transaction : ON
     * logRepository    @Transaction : ON Exception
     * -> 논리 트랜잭션 중 하나라도 롤백 되면 전체 롤백이 발생한다. (롤백 마크 발생)
     * */
    @Order(6)
    @DisplayName("트랜잭션 전파 활용6 - 복구 REQUIRED")
    @Test
    void recoverException_fail() {
        // given
        String username = "로그예외_recoverException_fail";
        // when
        assertThrows(
                UnexpectedRollbackException.class,
                () -> memberService.joinV5(username)
        );
        // then : 예외로 잡았음에도 불구하고 롤백 발생
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

}
