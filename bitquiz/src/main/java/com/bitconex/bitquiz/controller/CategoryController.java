package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.CategoryDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.CategoryResponse;
import com.bitconex.bitquiz.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bit")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        return ResponseEntity.ok(categoryDTOS.stream().map(CategoryDTO::dtoToResponse).collect(Collectors.toList()));
    }

}
