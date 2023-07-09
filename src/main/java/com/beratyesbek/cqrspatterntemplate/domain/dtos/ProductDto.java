package com.beratyesbek.cqrspatterntemplate.domain.dtos;

import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(
        String name,
        String description,
        int quantity,
        BigDecimal price,
        CategoryDto category
) {
}
