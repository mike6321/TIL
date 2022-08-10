package com.example.spring.transaction.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
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

}
