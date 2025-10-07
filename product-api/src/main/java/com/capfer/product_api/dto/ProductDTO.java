package com.capfer.product_api.dto;

import com.capfer.product_api.mapper.ProductMapper;
import com.capfer.product_api.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO (
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        String productIdentifier,
        @NotNull
        Float price,
        @NotNull
        CategoryDTO category
) {

    public static ProductDTO convert(Product product) {
        return ProductMapper.toDTO(product);
    }
}
