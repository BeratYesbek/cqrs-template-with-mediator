package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.base;


import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationErrorRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationSuccessRuleResult;

public interface RuleForNumbers {

    default ValidationRuleResult graderThan(Number value, Number target, String message) {
        if (value.doubleValue() > target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult graderThanOrEquals(Number value, Number target, String message) {
        if (value.doubleValue() >= target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThan(Number value, Number target, String message) {
        if (value.doubleValue() < target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThanOrEquals(Number value, Number target, String message) {
        if (value.doubleValue() <= target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }
}
