package com.beratyesbek.cqrspatterntemplate.application.commands.category.validation;

import com.beratyesbek.cqrspatterntemplate.application.commands.category.CreateCategoryCommand;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.Validator;

public final class CategoryValidator implements Validator<CreateCategoryCommand> {

    @Override
    public void validate(CreateCategoryCommand command) {
        invoke(
                notNull(command.name(), "Name cannot be null"),
                lessThan(1, command.name().length(), "Name cannot be less than 1 characters")
               // graderThan(command.name().length(), 50, "Name cannot be grader than 50 characters")
        );

    }
}
