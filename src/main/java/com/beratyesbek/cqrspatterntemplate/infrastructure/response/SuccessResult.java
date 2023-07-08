package com.beratyesbek.cqrspatterntemplate.infrastructure.response;


public final class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(message, true);
    }
}
