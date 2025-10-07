package com.capfer.product_api.mapper;

import com.capfer.product_api.dto.CategoryDTO;
import com.capfer.product_api.model.Category;

public final class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.id());
        category.setName(categoryDTO.name());
        return category;
    }
}
