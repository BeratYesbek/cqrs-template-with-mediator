package com.beratyesbek.cqrspatterntemplate.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public sealed class Result permits DataResult, SuccessResult, ErrorResult {

    private String message;

    private boolean success;

    protected Result(boolean code) {
        this.success = success;
    }

}
