package com.capfer.product_api.repository;

import com.capfer.product_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
                SELECT P FROM product P
                JOIN category c ON P.category_id = c.id
                WHERE c.id = :categoryId
            """, nativeQuery = true)
    List<Product> getProductByCategory(@Param("categoryId") long categoryId);

    Product findByProductIdentifier(String productIdentifier);
}
