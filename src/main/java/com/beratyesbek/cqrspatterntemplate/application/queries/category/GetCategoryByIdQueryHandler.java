package com.beratyesbek.cqrspatterntemplate.application.queries.category;

import com.beratyesbek.cqrspatterntemplate.domain.dtos.CategoryDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessDataResult;
import com.beratyesbek.cqrspatterntemplate.persistance.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.beratyesbek.cqrspatterntemplate.application.mappers.CategoryMapper.mapToCategoryDto;

@Service
@RequiredArgsConstructor
public class GetCategoryByIdQueryHandler implements RequestHandler<GetCategoryByIdQuery, DataResult<CategoryDto>> {

    private final CategoryRepository categoryRepository;

    @Override
    public DataResult<CategoryDto> handle(GetCategoryByIdQuery getCategoryByIdQuery) {
        Category categry =  categoryRepository.findById(getCategoryByIdQuery.id()).orElseThrow(
                () -> new RuntimeException("Category not found")
        );
        return new SuccessDataResult<>(mapToCategoryDto(categry));
    }
}
