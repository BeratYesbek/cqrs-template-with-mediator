package com.beratyesbek.cqrspatterntemplate.application.mappers;

import com.beratyesbek.cqrspatterntemplate.application.commands.category.CreateCategoryCommand;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;

public final class CategoryMapper {

    private CategoryMapper() {

    }

    public static Category mapToCategory(CreateCategoryCommand createCategoryCommand) {
        return Category.builder()
                .name(createCategoryCommand.name()).build();
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder().name(category.getName()).build();
    }
}
