package com.example.java.effectivejava.item26.genericdao;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountRepositoryTest {

    @Test
    void findById() {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account(1L, "junwoo");
        accountRepository.add(account);

        Optional<Account> byId = accountRepository.findById(1L);
        assertTrue(byId.isPresent());
    }

}
