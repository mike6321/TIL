package com.example.casecade;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@RequiredArgsConstructor
public class CascadeRunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("junwoo");
        account.setPassword("1234");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account loadAccount = session.load(Account.class, account.getId());
        System.out.println("***************************************");
        loadAccount.setPassword("123");
        loadAccount.setPassword("123");
        loadAccount.setPassword("123");
        System.out.println(loadAccount.getId());
        System.out.println(loadAccount.getUsername());
    }

}
