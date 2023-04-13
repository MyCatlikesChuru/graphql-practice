package com.prac.graphql.global.exception;


import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class BusinessLogicException extends RuntimeException implements GraphQLError {

    @Getter
    private final ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = new LinkedHashMap<>();
        customAttributes.put("status", exceptionCode.getStatus());
        customAttributes.put("exceptionMessage", exceptionCode.getMessage());
        return customAttributes;
    }
}
