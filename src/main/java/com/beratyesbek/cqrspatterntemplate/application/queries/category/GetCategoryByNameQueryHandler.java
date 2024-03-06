package com.beratyesbek.cqrspatterntemplate.application.queries.category;


import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.cache.CacheAspect;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.ErrorDataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessDataResult;
import com.beratyesbek.cqrspatterntemplate.persistance.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.beratyesbek.cqrspatterntemplate.application.mappers.CategoryMapper.mapToCategoryDto;

@Service
@RequiredArgsConstructor
public class GetCategoryByNameQueryHandler implements RequestHandler<GetCategoryByNameQuery, DataResult<CategoryDto>> {

    private final CategoryRepository categoryRepository;

    @Override
    @CacheAspect(key = "CategoryHandler")
    public DataResult<CategoryDto> handle(GetCategoryByNameQuery getCategoryByNameQuery) {
        Category category = categoryRepository.findByName(getCategoryByNameQuery.name());
        if (category == null) {
            return new ErrorDataResult<>(null, "Category not found!!!");
        }
        return new SuccessDataResult<>(mapToCategoryDto(category));
    }
}
