package com.example.dddleaning.domain.entities;

import com.example.dddleaning.domain.valueobjects.Name;
import com.example.dddleaning.domain.valueobjects.Price;
import com.example.dddleaning.domain.valueobjects.ProductId;
import com.example.dddleaning.infrastructure.entities.ProductEntity;

public class Product extends EntityBase<Product>{
    private ProductId productId;
    private Name name;
    private  String description;
    private Price price;

    public Product(Name name, String description, Price price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(ProductId productId, Name name, String description, Price price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
