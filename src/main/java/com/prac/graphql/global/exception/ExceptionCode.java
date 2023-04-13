package com.prac.graphql.global.exception;

import lombok.Getter;

public enum ExceptionCode {

    MEMBER_NOT_FOUND(404, "회원이 존재하지 않습니다.");

    @Getter
    private final int status;

    @Getter
    private final String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
