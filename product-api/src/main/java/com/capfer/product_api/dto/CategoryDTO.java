package com.capfer.product_api.dto;

import com.capfer.product_api.mapper.CategoryMapper;
import com.capfer.product_api.model.Category;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(@NotNull Long id, String name) {

    public static CategoryDTO convert(Category category) {
        return CategoryMapper.toDTO(category);
    }
}
