package com.choi.test_code.member;

import com.choi.test_code.domain.Member;
import com.choi.test_code.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);

}
