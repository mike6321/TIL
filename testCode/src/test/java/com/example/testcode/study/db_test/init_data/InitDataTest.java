package com.example.testcode.study.db_test.init_data;

import com.example.testcode.domain.Member;
import com.example.testcode.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class InitDataTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("데이터 초기화 테스트 - success")
    @Sql("/create-member.sql")
    @Test
    void init_data_ok_test() {
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Member 데이터가 존재하지 않습니다."));
        assertNotNull(member);
    }

    @DisplayName("데이터 초기화 테스트 - fail")
    @Sql("/create-member.sql")
    @Test
    void init_data_fail_test() {
        assertThrows(EntityNotFoundException.class, () -> memberRepository.findById(3L)
                .orElseThrow(() -> new EntityNotFoundException("Member 데이터가 존재하지 않습니다.")));
    }

    @DisplayName("auto flush 인지 확인")
    @Test
    void auto_flush_test() {
        Member member = new Member();
        member.setEmail("test1@test.com");
        Member savedMember = memberRepository.save(member);
        Long id = savedMember.getId();
        System.out.println("id = " + id);

        Member findMember = memberRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        assertNotNull(findMember);
    }

}
