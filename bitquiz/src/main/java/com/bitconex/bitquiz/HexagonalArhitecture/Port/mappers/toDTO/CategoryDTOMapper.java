package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.CategoryDTO;
import com.bitconex.bitquiz.entity.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryDTOMapper implements Function<Category, CategoryDTO> {
    @Override
    public CategoryDTO apply(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }
}
