package com.example.dddleaning.config;

import com.example.dddleaning.domain.interfaces.ProductRepository;
import com.example.dddleaning.domain.interfaces.UserRepository;
import com.example.dddleaning.infrastructure.repositories.ProductCrudRepository;
import com.example.dddleaning.infrastructure.repositories.UserCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserRepository userRepository(){
        return new UserCrudRepository();
    }
    @Bean
    public ProductRepository productRepository(){
        return  new ProductCrudRepository();
    }

}
