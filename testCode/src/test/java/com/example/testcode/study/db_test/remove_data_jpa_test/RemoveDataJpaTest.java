package com.example.testcode.study.db_test.remove_data_jpa_test;

import com.example.testcode.domain.Member;
import com.example.testcode.member.MemberRepository;
import org.junit.jupiter.api.*;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDataJpaTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static MemberRepository memberRepository;
    private static EntityTransaction transaction;

    @BeforeAll
    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("InMemoryRepository");
        entityManager = entityManagerFactory.createEntityManager();
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
        memberRepository = factory.getRepository(MemberRepository.class);
        transaction = entityManager.getTransaction();
    }

    @BeforeEach
    void beginTransaction() {
        transaction.begin();
    }

    @AfterEach
    void commitTransaction() {
        transaction.commit();
    }

    @DisplayName("@DataJpaTest 제거 테스트")
    @Test
    @Transactional
    void remove_data_jpa_test() {
        Member member = new Member();
        member.setEmail("test1@test.com");
        memberRepository.save(member);
        entityManager.flush();
        entityManager.clear();
        long count = memberRepository.findAll()
                .stream()
                .count();
        assertEquals(count, 1);
    }

}
