package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationSuccessRuleResult extends ValidationRuleResult{
    public ValidationSuccessRuleResult(String message) {
        super(true, message);
    }
}
