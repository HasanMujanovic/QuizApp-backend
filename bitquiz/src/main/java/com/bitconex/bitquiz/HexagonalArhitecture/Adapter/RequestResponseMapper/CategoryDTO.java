package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.CategoryRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.CategoryResponse;
import lombok.Data;

@Data
public class CategoryDTO {
    private int id;
    private String name;

    public static CategoryDTO requestToDto(CategoryRequest categoryRequest){
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setName(categoryRequest.getName());
        categoryDTO.setId(categoryRequest.getId());

        return categoryDTO;
    }

    public static CategoryResponse dtoToResponse(CategoryDTO categoryDTO){
        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setName(categoryDTO.getName());
        categoryResponse.setId(categoryDTO.getId());

        return categoryResponse;
    }
}
