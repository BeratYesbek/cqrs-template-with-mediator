package com.beratyesbek.cqrspatterntemplate.application.commands.category;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Handler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;
import com.fasterxml.jackson.annotation.JsonProperty;

@Handler(handler = CreateCategoryCommandHandler.class)
public record CreateCategoryCommand(@JsonProperty("name") String name) implements Request {
}
