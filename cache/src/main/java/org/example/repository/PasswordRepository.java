package org.example.repository;

import org.example.domain.Password;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends ListCrudRepository<Password, Long>, InsertableRepository<Password> {

}
