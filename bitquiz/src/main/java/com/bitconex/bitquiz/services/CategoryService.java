package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.CategoryDTO;

import java.util.List;

public interface CategoryService {
   List<CategoryDTO> getAllCategories();
}
