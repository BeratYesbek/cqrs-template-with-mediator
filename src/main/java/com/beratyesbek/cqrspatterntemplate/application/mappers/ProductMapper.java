package com.beratyesbek.cqrspatterntemplate.application.mappers;

import com.beratyesbek.cqrspatterntemplate.application.commands.product.create.CreateProductCommand;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.ProductDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Product;

import static com.beratyesbek.cqrspatterntemplate.application.mappers.CategoryMapper.mapToCategoryDto;

public final class ProductMapper {

    private ProductMapper() {

    }

    public static Product mapToProduct(CreateProductCommand createProductCommand, Category category) {
        return Product.builder()
                .description(createProductCommand.description())
                .price(createProductCommand.price())
                .quantity(createProductCommand.quantity())
                .name(createProductCommand.name())
                .category(category)
                .build();
    }

    public static ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .name(product.getName())
                .category(mapToCategoryDto(product.getCategory()))
                .build();
    }

}
