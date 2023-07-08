package com.beratyesbek.cqrspatterntemplate.application.commands.product.create;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Handler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


@Handler(handler = CreateProductCommandHandler.class)
public record CreateProductCommand (
        @JsonProperty("name")
        String name,
        @JsonProperty("category_id")
        int categoryId,
        @JsonProperty("quantity")
        int quantity,
        @JsonProperty("price")
        BigDecimal price,
        @JsonProperty("description")
        String description
) implements Request {

}
