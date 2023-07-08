package com.beratyesbek.cqrspatterntemplate.infrastructure.response;

public final class ErrorResult extends Result {
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(message, false);
    }
}
