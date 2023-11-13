package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Member;
import org.example.domain.Password;
import org.example.repository.MemberRepository;
import org.example.repository.PasswordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final MemberRepository memberRepository;
    private final PasswordRepository passwordRepository;

    @Transactional
    public Member create(CreateMemberCommand command) {
        Member member = new Member(command.userCode());
        memberRepository.insert(member);

        Password password = new Password(member, command.password());
        passwordRepository.insert(password);

        return member;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}
