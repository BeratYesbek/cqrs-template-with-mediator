package com.beratyesbek.cqrspatterntemplate.application.commands.product.create;

import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.ProductDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Product;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.ErrorDataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessDataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.persistance.CategoryRepository;
import com.beratyesbek.cqrspatterntemplate.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.beratyesbek.cqrspatterntemplate.application.mappers.ProductMapper.mapToProduct;
import static com.beratyesbek.cqrspatterntemplate.application.mappers.ProductMapper.mapToProductDto;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler implements RequestHandler<CreateProductCommand, DataResult<ProductDto>> {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public DataResult<ProductDto> handle(CreateProductCommand createProductCommand) {
        Optional<Category> category = categoryRepository.findById(createProductCommand.categoryId());
        if (category.isEmpty()) {
            return new ErrorDataResult<>("Category Not Found");
        }
        Product product = productRepository.save(mapToProduct(createProductCommand,category.get()));
        return new SuccessDataResult<>(mapToProductDto(product),"Product has been created!!!");
    }




}
