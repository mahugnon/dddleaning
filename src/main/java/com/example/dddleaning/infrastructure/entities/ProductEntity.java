package com.example.dddleaning.infrastructure.entities;

import com.example.dddleaning.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double price;



    public static ProductEntity create(Product product){
       return  new ProductEntity(null, product.getName().toString(),
                product.getDescription().toString(),
                product.getPrice().toDouble());

    }

}
