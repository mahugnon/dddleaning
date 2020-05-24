package com.example.dddleaning.infrastructure.imports;

import com.example.dddleaning.infrastructure.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImportedUserCrudRepository extends CrudRepository<UserEntity,Long> {
Optional<UserEntity> findByEmail(String email);
}
