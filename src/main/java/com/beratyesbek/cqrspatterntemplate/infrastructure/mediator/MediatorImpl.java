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
            throw new IllegalArgumentException("Request cannot be null");
        }

        Handler handlerAnnotation = request.getClass().getAnnotation(Handler.class);

        if (handlerAnnotation == null) {
            throw new IllegalArgumentException("Handler annotation not found for request class: " + request.getClass().getName());
        }

        Class<?> requestHandler = handlerAnnotation.handler();
        Object handlerBean = context.getBean(requestHandler);

        if (!(handlerBean instanceof RequestHandler)) {
            throw new IllegalArgumentException("Handler bean does not implement RequestHandler interface: " + requestHandler.getName());
        }

        RequestHandler<TRequest, Result> handler = (RequestHandler<TRequest, Result>) handlerBean;
        return (TResponse) handler.handle(request);
    }
}
