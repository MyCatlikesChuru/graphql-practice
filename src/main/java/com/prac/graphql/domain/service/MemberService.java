package com.prac.graphql.domain.service;

import com.prac.graphql.domain.entity.Member;
import com.prac.graphql.domain.repository.MemberRepository;
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
        return findMember.orElseThrow(() -> new RuntimeException("회원이 없습니다."));
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

}
