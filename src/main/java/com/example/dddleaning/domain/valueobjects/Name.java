package com.example.dddleaning.domain.valueobjects;

import com.example.dddleaning.domain.valueobjects.base.ValueObject;

public  class Name extends ValueObject<String> {
    public Name(final String name) {
        if (name==null) {
            throw new IllegalArgumentException("Name should not be null");
        }
        if (name.trim().equals("")){
            throw  new IllegalArgumentException("Name should not be empty");
        }
        this.value = name;
    }
}
