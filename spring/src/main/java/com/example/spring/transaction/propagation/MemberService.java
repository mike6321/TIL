package com.example.spring.transaction.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final LogRepository logRepository;

    public void joinV1(String username) {
        Member member = new Member(username);
        Log logMessage = new Log(username);

        log.info("***** memberRepository 호출 시작 *****");
        memberRepository.saveV1(member);
        log.info("***** memberRepository 호출 종료 *****");

        log.info("***** logRepository 호출 시작 *****");
        logRepository.saveV1(logMessage);
        log.info("***** logRepository 호출 종료 *****");
    }

    @Transactional
    public void joinV2(String username) {
        Member member = new Member(username);
        Log logMessage = new Log(username);

        log.info("***** memberRepository 호출 시작 *****");
        memberRepository.saveV2(member);
        log.info("***** memberRepository 호출 종료 *****");

        log.info("***** logRepository 호출 시작 *****");
        logRepository.saveV2(logMessage);
        log.info("***** logRepository 호출 종료 *****");
    }

    @Transactional
    public void joinV3(String username) {
        Member member = new Member(username);
        Log logMessage = new Log(username);

        log.info("***** memberRepository 호출 시작 *****");
        memberRepository.saveV3(member);
        log.info("***** memberRepository 호출 종료 *****");

        log.info("***** logRepository 호출 시작 *****");
        logRepository.saveV3(logMessage);
        log.info("***** logRepository 호출 종료 *****");
    }

    @Transactional
    public void joinV4(String username) {
        Member member = new Member(username);
        Log logMessage = new Log(username);

        log.info("***** memberRepository 호출 시작 *****");
        memberRepository.saveV4(member);
        log.info("***** memberRepository 호출 종료 *****");

        log.info("***** logRepository 호출 시작 *****");
        logRepository.saveV4(logMessage);
        log.info("***** logRepository 호출 종료 *****");

    }

}
