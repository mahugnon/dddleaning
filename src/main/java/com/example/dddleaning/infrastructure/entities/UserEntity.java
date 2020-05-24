package com.example.dddleaning.infrastructure.entities;

import com.example.dddleaning.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean isAdmin;
    public static UserEntity create(User user){
        return new UserEntity(null,
                user.getName().toString(),
                user.getEmail().toString(),
                user.getPassword().toString(),
                user.getAdmin()) ;
    }
}
