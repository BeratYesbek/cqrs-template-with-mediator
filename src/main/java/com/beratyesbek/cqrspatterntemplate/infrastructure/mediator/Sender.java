package com.beratyesbek.cqrspatterntemplate.infrastructure.mediator;

import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;

public interface Sender {
     <TRequest extends Request, TResponse extends Result> TResponse send(TRequest request);

}
