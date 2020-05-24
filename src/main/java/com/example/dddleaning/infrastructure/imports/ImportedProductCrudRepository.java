package com.example.dddleaning.infrastructure.imports;

import com.example.dddleaning.infrastructure.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportedProductCrudRepository extends CrudRepository<ProductEntity,Long> {
}
