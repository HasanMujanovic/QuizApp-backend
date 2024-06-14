package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.CategoryDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.CategoryDTOMapper;
import com.bitconex.bitquiz.entity.Category;
import com.bitconex.bitquiz.repository.CategoryRepository;
import com.bitconex.bitquiz.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryDTOMapper categoryDTOMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(res -> categoryDTOMapper.apply(res)).collect(Collectors.toList());
    }
}
