package com.beratyesbek.cqrspatterntemplate.controller;

import com.beratyesbek.cqrspatterntemplate.application.commands.category.CreateCategoryCommand;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Mediator;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController extends BaseController {


    @PostMapping
    public ResponseEntity<DataResult<CategoryDto>> create(@RequestBody CreateCategoryCommand createCategoryCommand) {
        return ResponseEntity.ok(mediator.send(createCategoryCommand));
    }

}
