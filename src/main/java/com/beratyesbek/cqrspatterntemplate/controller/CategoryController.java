package com.beratyesbek.cqrspatterntemplate.controller;

import com.beratyesbek.cqrspatterntemplate.application.commands.category.CreateCategoryCommand;
import com.beratyesbek.cqrspatterntemplate.application.queries.category.GetCategoryByIdQuery;
import com.beratyesbek.cqrspatterntemplate.application.queries.category.GetCategoryByNameQuery;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Mediator;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("api/categories")
public class CategoryController extends BaseController {
    public CategoryController(Mediator mediator) {
        super(mediator);
    }

    @PostMapping
    public ResponseEntity<DataResult<CategoryDto>> create(@RequestBody CreateCategoryCommand createCategoryCommand) {
        return ResponseEntity.ok(mediator.send(createCategoryCommand));
    }

    @GetMapping("/getByName")
    public ResponseEntity<DataResult<CategoryDto>> getByName(@RequestParam String name){
        return ResponseEntity.ok(mediator.send(new GetCategoryByNameQuery(name)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<CategoryDto>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mediator.send(new GetCategoryByIdQuery(id)));
    }



}
