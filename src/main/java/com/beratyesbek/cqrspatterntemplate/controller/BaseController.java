package com.beratyesbek.cqrspatterntemplate.controller;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Mediator;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {
    @Autowired
    protected Mediator mediator;

}
