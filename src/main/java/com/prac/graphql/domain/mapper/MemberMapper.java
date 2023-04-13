package com.prac.graphql.domain.mapper;

import com.prac.graphql.domain.dto.MemberResponseDto;
import com.prac.graphql.domain.entity.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {
    public static MemberResponseDto memberToMemberResponseDto(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .build();
    }

    public static List<MemberResponseDto> memberListToMemberResponseDtoList(List<Member> members) {
        return members.stream()
                .map(member -> {
                    return memberToMemberResponseDto(member);
                })
                .collect(Collectors.toList());
    }

    public static Member toEntity(String name, Integer age) {
        Member newMember = new Member();
        newMember.setName(name);
        newMember.setAge(age);
        return newMember;
    }
}
