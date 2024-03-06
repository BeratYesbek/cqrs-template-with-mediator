package com.beratyesbek.cqrspatterntemplate.application.queries.category;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Handler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;

@Handler(handler = GetCategoryByIdQueryHandler.class)
public record GetCategoryByIdQuery(Integer id) implements Request {
}
