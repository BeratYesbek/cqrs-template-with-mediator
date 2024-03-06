package com.beratyesbek.cqrspatterntemplate.application.queries.category;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Handler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;
import com.fasterxml.jackson.annotation.JsonProperty;

@Handler(handler = GetCategoryByNameQueryHandler.class)
public record GetCategoryByNameQuery(@JsonProperty String name) implements Request {
}
