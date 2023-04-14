package com.prac.graphql.domain.controller;

import com.prac.graphql.domain.dto.MemberResponseDto;
import com.prac.graphql.domain.entity.Member;
import com.prac.graphql.domain.mapper.MemberMapper;
import com.prac.graphql.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/*
* EndPoint : http://localhost:8080/graphql
* Test 접속 URL : http://localhost:8080/graphiql 에 쿼리를 입력
* */
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    /*
    * @QueryMapping
    * -> 주로 Read에 사용됩니다. (REST API @GetMapping과 대응)
    * */

    @QueryMapping
    public Member getMember(@Argument Long id){
        return memberService.findMemberById(id);
    }

    @QueryMapping
    public List<Member> getMembers(){
        return memberService.findAllMember();
    }

    @QueryMapping
    public MemberResponseDto getMemberResponseDto(@Argument Long id){
        Member member = memberService.findMemberById(id);
        return memberMapper.memberToMemberResponseDto(member);
    }

    @QueryMapping
    public List<MemberResponseDto> getMembersResponseDto(){
        List<Member> allMember = memberService.findAllMember();
        return memberMapper.memberListToMemberResponseDtoList(allMember);
    }


    /*
    * 활용, 매개변수를 여러개로 받기
    * 매개변수에 값을 넣지않고 줄떄는 null 값으로 보내짐
    * */
    @QueryMapping
    public Member getMemberAdvance(@Argument(name = "id") Long id,
                                   @Argument(name = "search") String search,
                                   @Argument(name = "category") String category,
                                   @Argument(name = "address") String address,
                                   @Argument(name = "filter") String filter,
                                   @Argument(name = "start") String start,
                                   @Argument(name = "end") String end,
                                   @Argument(name = "page") Integer page,
                                   @Argument(name = "size") Integer size ) {

        log.info("id = {}", id);
        log.info("search = {}", search);
        log.info("category = {}", category);
        log.info("address = {}", address);
        log.info("filter = {}", filter);
        log.info("start = {}", start);
        log.info("end = {}", end);
        log.info("page = {}", page);
        log.info("size = {}", size);

        return memberService.findMemberById(Long.valueOf(id));
    }


    /*
    * @MutationMapping
    * -> 주로 Create, Update, Delete에 사용됩니다.
    * */
    @MutationMapping
    public Member postMember(@Argument String name,
                             @Argument Integer age){

        Member member = memberMapper.toEntity(name, age);
        return memberService.saveMember(member);
    }

    /*
    * @SchemaMapping
    * -> @QueryMapping, @MutationMapping 를 선택하여 사용할 수 있음.
    * */
    @SchemaMapping(typeName = "Query")
    public Member getMemberBySchema(@Argument Long id) {
        return memberService.findMemberById(id);
    }

    @SchemaMapping(typeName = "Query")
    public List<Member> getMembersBySchema() {
        return memberService.findAllMember();
    }

    @SchemaMapping(typeName = "Mutation")
    public Member postMemberByMutation(@Argument String name,
                                       @Argument Integer age){
        Member member = memberMapper.toEntity(name, age);
        return memberService.saveMember(member);
    }

}
