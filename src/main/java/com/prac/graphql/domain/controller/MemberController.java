package com.prac.graphql.domain.controller;

import com.prac.graphql.domain.entity.Member;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    @QueryMapping
    public Member getMember(@Argument Long id){
        return new Member(id,"이재혁",29);
    }

}
