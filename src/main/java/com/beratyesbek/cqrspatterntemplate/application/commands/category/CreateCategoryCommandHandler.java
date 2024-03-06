package com.beratyesbek.cqrspatterntemplate.application.commands.category;

import com.beratyesbek.cqrspatterntemplate.application.commands.category.validation.CategoryValidator;
import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.cache.CacheRemoveAspect;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations.Validation;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessDataResult;
import com.beratyesbek.cqrspatterntemplate.persistance.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.beratyesbek.cqrspatterntemplate.application.mappers.CategoryMapper.mapToCategory;
import static com.beratyesbek.cqrspatterntemplate.application.mappers.CategoryMapper.mapToCategoryDto;

@Service
@RequiredArgsConstructor
public class CreateCategoryCommandHandler implements RequestHandler<CreateCategoryCommand, DataResult<CategoryDto>> {

    private final CategoryRepository categoryRepository;

    @Override
    @Validation(validator = CategoryValidator.class)
    @CacheRemoveAspect(key = {"CategoryHandler"})
    public DataResult<CategoryDto> handle(CreateCategoryCommand createCategoryCommand) {
        Category category = categoryRepository.save(mapToCategory(createCategoryCommand));
        return new SuccessDataResult<>(mapToCategoryDto(category), "Category has been created!!!");
    }




}
