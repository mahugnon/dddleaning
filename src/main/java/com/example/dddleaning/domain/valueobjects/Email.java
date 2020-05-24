package com.example.dddleaning.domain.valueobjects;

import com.example.dddleaning.domain.valueobjects.base.ValueObject;

public  class Email extends ValueObject<String> {
    public Email(final String email) {
        if (email==null){
            throw new IllegalArgumentException("The email should not be null");

        }
        if (!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            throw  new IllegalArgumentException("The email is not valid");
        }
        this.value = email;
    }
}
