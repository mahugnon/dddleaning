package com.example.dddleaning.infrastructure.repositories;

import com.example.dddleaning.domain.entities.Product;
import com.example.dddleaning.domain.interfaces.ProductRepository;
import com.example.dddleaning.domain.valueobjects.Name;
import com.example.dddleaning.domain.valueobjects.Price;
import com.example.dddleaning.domain.valueobjects.ProductId;
import com.example.dddleaning.infrastructure.entities.ProductEntity;
import com.example.dddleaning.infrastructure.imports.ImportedProductCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductCrudRepository implements ProductRepository {
    ImportedProductCrudRepository impl;

    public ProductCrudRepository(ImportedProductCrudRepository impl) {
        this.impl = impl;
    }

    public ProductCrudRepository() {

    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = ProductEntity.create(product);
        product.setProductId(new ProductId(impl.save(productEntity).getId()));
        return product;
    }

    @Override
    public Optional<Product> findByProductId(ProductId productId) {
        Optional<Product> optionalProduct = impl.findById(productId.toLong()).map(ProductCrudRepository::toProduct);
        return optionalProduct;
    }

    @Override
    public void deleteByProductId(ProductId productId) {
impl.deleteById(productId.toLong());
    }

    @Override
    public List<Product> findAll() {
        return StreamSupport.stream(impl.findAll().spliterator(),false).map(ProductCrudRepository::toProduct).collect(Collectors.toList());
    }
    private static Product toProduct(ProductEntity productEntity){
        return new Product(new ProductId(productEntity.getId()),
                new Name(productEntity.getName()),
                productEntity.getDescription(),
                new Price(productEntity.getPrice()));
    }
}
