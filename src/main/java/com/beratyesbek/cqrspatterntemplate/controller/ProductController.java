package com.beratyesbek.cqrspatterntemplate.controller;

import com.beratyesbek.cqrspatterntemplate.application.commands.products.create.CreateProductCommand;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Mediator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController extends BaseController{


    public ProductController(Mediator mediator) {
        super(mediator);
    }


}
