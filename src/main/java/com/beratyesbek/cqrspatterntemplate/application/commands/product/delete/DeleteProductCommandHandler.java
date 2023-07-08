package com.beratyesbek.cqrspatterntemplate.application.commands.product.delete;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.Result;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessResult;
import com.beratyesbek.cqrspatterntemplate.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductCommandHandler implements RequestHandler<DeleteProductCommand, Result> {

    private final ProductRepository productRepository;

    @Override
    public Result handle(DeleteProductCommand deleteProductCommand) {
        productRepository.deleteById(deleteProductCommand.id());
        return new SuccessResult("Product has been deleted!!!");
    }
}
