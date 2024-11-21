package com.ecom.caltalog.application.category.getallcategory;

import com.ecom.caltalog.infrastructure.repositories.CategoryRepository;
import com.ecom.shared.application.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCategoryQueryHandler implements QueryHandler<GetAllCategoryQuery, List<GetAllCategoryDto>> {

    private final CategoryRepository repository;

    public GetAllCategoryQueryHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetAllCategoryDto> handle(GetAllCategoryQuery query) {
        return repository.findAll().stream()
                .map(category -> new GetAllCategoryDto(
                        category.getId(),
                        category.getName(),
                        category.getDescription()
                ))
                .toList();
    }
}

