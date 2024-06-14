package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.CategoryDTO;
import com.bitconex.bitquiz.entity.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryMapper implements Function<CategoryDTO, Category> {
    @Override
    public Category apply(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        return category;
    }
}
