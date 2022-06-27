package com.example.service;

import com.example.domain.Member;
import com.example.dto.ReqCreateMember;
import com.example.dto.ResCreateMember;
import com.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public ResCreateMember createMember(ReqCreateMember reqCreateMember) {
        String encodePassword = passwordEncoder.encode(reqCreateMember.getPassword());
        reqCreateMember.encodePassword(encodePassword);
        Member member = Member.createMember(reqCreateMember);
        Member createdMember = memberRepository.save(member);
        return ResCreateMember.of(createdMember);
    }

}
