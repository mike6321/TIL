package com.example.osiv;

import com.example.osiv.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberRequest memberRequest) {
        memberRepository.save(Member.of(memberRequest));
    }

}
