package com.example.version.V_2_1.auto_setup_support;

import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Transactional(readOnly = true)
    @Query("select * from Book where isbn = :isbn")
    Book finByIsbn(@Param("isbn") String isbn);

}
