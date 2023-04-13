package com.prac.graphql.domain.service;

import com.prac.graphql.domain.entity.Member;
import com.prac.graphql.domain.repository.MemberRepository;
import com.prac.graphql.global.exception.BusinessLogicException;
import com.prac.graphql.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMemberById(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);
        return findMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

}
