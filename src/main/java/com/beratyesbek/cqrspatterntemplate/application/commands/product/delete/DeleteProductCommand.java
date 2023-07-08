package com.beratyesbek.cqrspatterntemplate.application.commands.product.delete;


import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Handler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;

@Handler(handler = DeleteProductCommandHandler.class)
public record DeleteProductCommand(int id) implements Request {

}
