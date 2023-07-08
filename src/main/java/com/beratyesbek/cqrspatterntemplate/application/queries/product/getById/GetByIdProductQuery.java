package com.beratyesbek.cqrspatterntemplate.application.queries.product.getById;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Handler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;

@Handler(handler = GetByIdProductQueryHandler.class)
public record GetByIdProductQuery(int id) implements Request {
}
