package com.prac.graphql.domain.repository;

import com.prac.graphql.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
