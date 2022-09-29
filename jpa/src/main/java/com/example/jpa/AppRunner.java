package com.example.jpa;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Person.PersonId personId01 = Person.PersonId.of("junwoo", 1234);
        Person person = new Person(personId01, "1235");
        personRepository.save(person);
    }

}
