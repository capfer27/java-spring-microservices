package com.capfer.product_api.mapper;

import com.capfer.product_api.dto.ProductDTO;
import com.capfer.product_api.model.Product;

public final class ProductMapper {

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setProductIdentifier(productDTO.productIdentifier());
        product.setPrice(productDTO.price());
        if (productDTO.category() != null) {
            product.setCategory(CategoryMapper.toEntity(productDTO.category()));
        }
        return product;
    }

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO (
                product.getName(),
                product.getDescription(),
                product.getProductIdentifier(),
                product.getPrice(),
                product.getCategory() != null ? CategoryMapper.toDTO(product.getCategory()) : null
        );

        return productDTO;
    }
}
