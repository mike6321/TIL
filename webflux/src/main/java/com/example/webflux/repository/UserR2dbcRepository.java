package com.example.webflux.repository;

import com.example.webflux.dto.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User, Long> {
}
