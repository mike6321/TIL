package org.example.repository;

import org.example.domain.Member;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends ListCrudRepository<Member, Long>, InsertableRepository<Member> {

}
