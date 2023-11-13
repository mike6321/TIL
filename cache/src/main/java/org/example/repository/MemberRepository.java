package org.example.repository;

import org.example.domain.Member;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends ListCrudRepository<Member, Long>, InsertableRepository<Member> {

    Optional<Member> findByUserCode(String userCode);

}
