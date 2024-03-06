package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.base;


import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationErrorRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationSuccessRuleResult;

import java.util.regex.Pattern;

public interface RuleForStrings {

    default ValidationRuleResult greaterThan(String value, int length, String message) {
        if (value.length() > length) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult greaterThanAndEquals(String value, int length, String message) {
        if (value.length() > length) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThan(String value, int length, String message) {
        if (value.length() < length) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThanAndEquals(String value, int length, String message) {
        if (value.length() <= length) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThanAndGreaterThan(String value, int minTarget, int maxTarget, String message) {
        if (value.length() > minTarget && value.length() < maxTarget)
            return new ValidationSuccessRuleResult("");
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult contains(String value, String key, String message) {
        if (value.contains(key)) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult validateEmail(String email, String message) {
        boolean result = Pattern.compile("^(.+)@(\\\\S+)$")
                .matcher(email)
                .matches();
        if (result)
            return new ValidationSuccessRuleResult("");
        return new ValidationErrorRuleResult(message);
    }


    default ValidationRuleResult validatePhone(String phone, String message) {
        boolean result = Pattern.compile("^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?")
                .matcher(phone).matches();
        if (result)
            return new ValidationSuccessRuleResult("");
        return new ValidationErrorRuleResult(message);
    }


}
