package com.capfer.product_api.service;

import com.capfer.product_api.dto.ProductDTO;
import com.capfer.product_api.exception.CategoryNotFoundException;
import com.capfer.product_api.exception.ProductNotFoundException;
import com.capfer.product_api.exception.constants.ExceptionMessages;
import com.capfer.product_api.mapper.ProductMapper;
import com.capfer.product_api.model.Product;
import com.capfer.product_api.repository.CategoryRepository;
import com.capfer.product_api.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDTO::convert)
                .toList();
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        List<Product> productByCategory = productRepository.getProductByCategory(categoryId);
        return productByCategory.stream()
                .map(ProductDTO::convert)
                .toList();
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product == null) {
            return null;
        }

        return ProductMapper.toDTO(product);
    }

    public ProductDTO save(ProductDTO productDTO) {
        boolean existsCategory = categoryRepository.existsById(productDTO.category().id());
        if (!existsCategory) {
            throw new CategoryNotFoundException();
        }
        Product product = productRepository.save(ProductMapper.toEntity(productDTO));
        return ProductMapper.toDTO(product);
    }

    public ProductDTO delete(long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        optionalProduct.ifPresent(productRepository::delete);
        throw new ProductNotFoundException();
    }

    public ProductDTO editProduct(long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND));

        if (!productDTO.name().isBlank()) {
            product.setName(productDTO.name());
        }

        if (productDTO.price() != null) {
            product.setPrice(productDTO.price());
        }

        return ProductMapper.toDTO(product);
    }

    public Page<ProductDTO> getAllPage(Pageable page) {
        Page<Product> productPage = productRepository.findAll(page);
        return productPage.map(ProductMapper::toDTO);
    }
}
