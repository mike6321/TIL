package com.example.jpa.repository;

import com.example.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Person.PersonId> {

//    @Transactional(readOnly = true)
//    List<Person> findByPersonId(String style, Integer siteId, boolean published);

}
