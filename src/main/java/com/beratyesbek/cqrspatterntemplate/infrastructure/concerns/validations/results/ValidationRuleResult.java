package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results;

import lombok.Getter;

@Getter
public abstract class ValidationRuleResult {
    protected final boolean success;
    protected final  String message;

    public ValidationRuleResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
