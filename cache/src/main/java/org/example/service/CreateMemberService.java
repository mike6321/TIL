package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Member;
import org.example.domain.Password;
import org.example.repository.MemberRepository;
import org.example.repository.PasswordRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


    @Cacheable(cacheNames = {"account.members"})
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Cacheable(cacheNames = "member", keyGenerator = "memberKeyGenerator")
    public Optional<Member> getMember(QueryMemberCommand command) {
        System.out.println("Query : getMember");
        return memberRepository.findByUserCode(command.userCode());
    }

}
