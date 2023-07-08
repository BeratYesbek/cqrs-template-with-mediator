package com.beratyesbek.cqrspatterntemplate.infrastructure.response;

import lombok.Getter;

@Getter
public sealed class DataResult<T> extends Result permits SuccessDataResult, ErrorDataResult {
    T data;

    public DataResult(T data, boolean success, String message) {
        super(message, success);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }
}
