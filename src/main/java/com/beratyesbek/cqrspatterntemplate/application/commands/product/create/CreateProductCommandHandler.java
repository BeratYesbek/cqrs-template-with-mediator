package com.beratyesbek.cqrspatterntemplate.application.commands.product.create;

import com.beratyesbek.cqrspatterntemplate.domain.dtos.ProductDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Product;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessDataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler implements RequestHandler<CreateProductCommand, DataResult<ProductDto>> {

    private final ProductRepository productRepository;

    @Override
    public DataResult<ProductDto> handle(CreateProductCommand createProductCommand) {
        Product product = productRepository.save(mapToProduct(createProductCommand));
        return new SuccessDataResult<>(mapToProductDto(product),"Product has been created!!!");
    }

    private static Product mapToProduct(CreateProductCommand createProductCommand) {
        return Product.builder()
                .description(createProductCommand.description())
                .price(createProductCommand.price())
                .quantity(createProductCommand.quantity())
                .name(createProductCommand.name()).build();
    }

    private static ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .name(product.getName()).build();
    }
}
