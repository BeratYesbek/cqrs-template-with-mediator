package com.beratyesbek.cqrspatterntemplate.application.commands.products.create;

import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler implements RequestHandler<CreateProductCommand, Result> {

    private final ApplicationContext context;

    @Override
    public Result handle(CreateProductCommand createProductCommand) {
        return new SuccessResult(createProductCommand.name());
    }
}
