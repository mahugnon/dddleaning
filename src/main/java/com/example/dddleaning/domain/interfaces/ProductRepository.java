package com.example.dddleaning.domain.interfaces;

import com.example.dddleaning.domain.entities.Product;
import com.example.dddleaning.domain.valueobjects.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findByProductId(ProductId productId);
    void  deleteByProductId(ProductId productId);
    List<Product> findAll();
}
