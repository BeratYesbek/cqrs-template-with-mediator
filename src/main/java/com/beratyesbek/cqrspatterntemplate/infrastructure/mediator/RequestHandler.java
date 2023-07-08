package com.beratyesbek.cqrspatterntemplate.infrastructure.mediator;

import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;

public interface RequestHandler <TRequest extends Request, TResponse extends Result>{

          TResponse handle(TRequest tRequest);
     }
