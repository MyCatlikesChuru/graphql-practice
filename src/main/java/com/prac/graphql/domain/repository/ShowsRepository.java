package com.prac.graphql.domain.repository;

import com.prac.graphql.domain.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows, Long> {
}
