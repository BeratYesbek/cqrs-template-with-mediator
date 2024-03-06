package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations;


import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.base.BaseRule;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.results.ValidationRuleResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;


import java.util.ArrayList;
import java.util.List;

public interface Validator<T extends Request> extends BaseRule {
    void validate(T entity);
    default void invoke(final ValidationRuleResult... validationRules)  {
        List<String> errorMessages = new ArrayList<>();
        boolean exception = false;
        for (ValidationRuleResult item : validationRules) {
            if (!item.isSuccess()) {
                exception = true;
                errorMessages.add(item.getMessage());
            }
        }
        if (exception)
            throw new RuntimeException(errorMessages.get(0));
    }
}
