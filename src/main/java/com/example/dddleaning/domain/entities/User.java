package com.example.dddleaning.domain.entities;

import com.example.dddleaning.domain.valueobjects.Email;
import com.example.dddleaning.domain.valueobjects.Name;
import com.example.dddleaning.domain.valueobjects.UserId;

public class User extends EntityBase<User>{
    private UserId userId;
    private Name name;
    private Email email;
    private String password;
    private Boolean isAdmin=false;

    public User(Name name, Email email ) {
        this.name = name;
        this.email = email;
           }

    public User(UserId userId, Name name, Email email, Boolean isAdmin) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public User(UserId userId, Name name, Email email, String password, Boolean isAdmin) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
