package com.beratyesbek.cqrspatterntemplate.application.queries.product.getById;

import com.beratyesbek.cqrspatterntemplate.domain.dtos.ProductDto;
import com.beratyesbek.cqrspatterntemplate.domain.entities.Product;
import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.RequestHandler;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.DataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.ErrorDataResult;
import com.beratyesbek.cqrspatterntemplate.infrastructure.response.SuccessDataResult;
import com.beratyesbek.cqrspatterntemplate.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.beratyesbek.cqrspatterntemplate.application.mappers.ProductMapper.mapToProductDto;

@Service
@RequiredArgsConstructor
public class GetByIdProductQueryHandler implements RequestHandler<GetByIdProductQuery, DataResult<ProductDto>> {
    private final ProductRepository productRepository;
    @Override
    public DataResult<ProductDto> handle(GetByIdProductQuery getByIdProductQuery) {
        return productRepository.findById(getByIdProductQuery.id())
                .map(product -> (DataResult<ProductDto>) new SuccessDataResult<>(mapToProductDto(product),""))
                .orElse(new ErrorDataResult<>("Product Not Found"));
    }

}
