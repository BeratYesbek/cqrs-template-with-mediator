package com.beratyesbek.cqrspatterntemplate.domain.dtos;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
public record ProductDto(
        String name,
        String description,
        int quantity,
        BigDecimal price,
        CategoryDto category
) implements Serializable {
}
