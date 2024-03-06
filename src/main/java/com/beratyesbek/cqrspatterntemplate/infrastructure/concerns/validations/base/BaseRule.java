package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.base;


import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationErrorRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationSuccessRuleResult;

public interface BaseRule extends RuleForStrings, RuleForNumbers {

    default ValidationRuleResult notNull(Object object, String message) {
        if (object != null) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }


    default ValidationRuleResult notEmpty(String value, String message) {
        if (value.isEmpty())
            return new ValidationErrorRuleResult(message);
        return new ValidationSuccessRuleResult("");
    }
}
