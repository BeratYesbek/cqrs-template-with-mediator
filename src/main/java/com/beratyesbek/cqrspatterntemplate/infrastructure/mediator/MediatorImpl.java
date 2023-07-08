package com.beratyesbek.cqrspatterntemplate.infrastructure.mediator;

import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MediatorImpl implements Mediator {

    private final ApplicationContext context;

    @Override
    public <TRequest extends Request, TResponse extends Result> TResponse send(TRequest request) {
        if (request == null) {
            throw  new NullPointerException(request.getClass().getName());
        }
        Handler handlerAnnotation = request.getClass().getAnnotation(Handler.class);
        Class<?> requestHandler  = handlerAnnotation.handler();
        RequestHandler<TRequest, Result> handler = (RequestHandler<TRequest, Result>) context.getBean(requestHandler);

        return (TResponse) handler.handle(request);
    }
}
