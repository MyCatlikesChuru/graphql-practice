package com.prac.graphql.domain.service;

import com.prac.graphql.domain.repository.ShowsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ShowsService {

    private final ShowsRepository showsRepository;
}
