package com.beratyesbek.cqrspatterntemplate.controller;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Mediator;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class BaseController {

    protected final Mediator mediator;

}
