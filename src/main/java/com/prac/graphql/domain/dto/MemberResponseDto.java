package com.prac.graphql.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResponseDto {
    private Long id;
    private String name;
    private Integer age;
}
