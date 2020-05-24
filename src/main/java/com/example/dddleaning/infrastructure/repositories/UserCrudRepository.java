package com.example.dddleaning.infrastructure.repositories;

import com.example.dddleaning.domain.entities.User;
import com.example.dddleaning.domain.interfaces.UserRepository;
import com.example.dddleaning.domain.valueobjects.Email;
import com.example.dddleaning.domain.valueobjects.Name;
import com.example.dddleaning.domain.valueobjects.UserId;
import com.example.dddleaning.infrastructure.entities.UserEntity;
import com.example.dddleaning.infrastructure.imports.ImportedUserCrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCrudRepository  implements UserRepository {
   ImportedUserCrudRepository impl;

    public UserCrudRepository(ImportedUserCrudRepository impl) {
        this.impl = impl;
    }

    public UserCrudRepository() {

    }

    @Override
    public User save(User user) {
        UserEntity saveUser = impl.save(UserEntity.create(user));
        user.setUserId(new UserId(saveUser.getId()));
        return user;
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        Optional<User> optionalUser = impl.findByEmail(email.toString()).map(UserCrudRepository::toUser);
        return optionalUser;
    }

    @Override
    public Optional<User> findByUserId(UserId userId) {
        Optional<User> optionalUser = impl.findById(userId.toLong()).map(UserCrudRepository::toUser);
        return optionalUser;
    }
    private  static User  toUser(UserEntity userEntity){
        return new User(new UserId(userEntity.getId()),
                new Name(userEntity.getName()),
                new Email(userEntity.getEmail()),
                userEntity.getPassword(),
                userEntity.getIsAdmin());
    }
}
