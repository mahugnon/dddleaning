package com.example.dddleaning.domain.interfaces;

import com.example.dddleaning.domain.entities.User;
import com.example.dddleaning.domain.valueobjects.Email;
import com.example.dddleaning.domain.valueobjects.UserId;

import java.util.Optional;

public interface UserRepository {
User save(User user);
Optional<User> findByEmail(Email email);
Optional<User> findByUserId(UserId userId);
}
