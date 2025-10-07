package com.capfer.product_api.controller;

import com.capfer.product_api.dto.ProductDTO;
import com.capfer.product_api.exception.ProductNotFoundException;
import com.capfer.product_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOS = productService.getAll();
        return productDTOS;
    }

    @GetMapping("/products/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> products = productService.getProductByCategoryId(categoryId);
        return products;
    }

    @GetMapping("/products/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) {
        ProductDTO productDTO = productService.findByProductIdentifier(productIdentifier);
        return productDTO;
    }

    @PostMapping("/products")
    public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = productService.save(productDTO);
        return savedProduct;
    }

    @DeleteMapping("/products/{id}")
    public ProductDTO deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        ProductDTO deleted = productService.delete(id);
        return deleted;
    }
}
