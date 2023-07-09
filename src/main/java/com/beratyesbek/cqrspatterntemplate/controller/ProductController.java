package com.beratyesbek.cqrspatterntemplate.controller;


import com.beratyesbek.cqrspatterntemplate.application.commands.product.create.CreateProductCommand;
import com.beratyesbek.cqrspatterntemplate.application.commands.product.delete.DeleteProductCommand;
import com.beratyesbek.cqrspatterntemplate.application.queries.product.getById.GetByIdProductQuery;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.ProductDto;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Mediator;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController extends BaseController {

    @PostMapping
    public ResponseEntity<DataResult<ProductDto>> create(@RequestBody CreateProductCommand createProductCommand) {
        return ResponseEntity.ok(mediator.send(createProductCommand));
    }

    @GetMapping("{id}")
    public ResponseEntity<DataResult<ProductDto>> getById(@PathVariable int id) {
        return ResponseEntity.ok(mediator.send(new GetByIdProductQuery(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable int id) {
        return ResponseEntity.ok(mediator.send(new DeleteProductCommand(id)));
    }

}
