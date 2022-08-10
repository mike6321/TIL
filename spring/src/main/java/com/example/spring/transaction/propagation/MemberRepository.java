package com.example.spring.transaction.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    @Transactional
    public void saveV1(Member member) {
        log.info("Member 저장");
        entityManager.persist(member);
    }

    public void saveV2(Member member) {
        log.info("Member 저장");
        entityManager.persist(member);
    }

    public Optional<Member> find(String username) {
        return entityManager.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findAny();
    }

}
