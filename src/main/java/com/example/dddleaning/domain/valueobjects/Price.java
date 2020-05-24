package com.example.dddleaning.domain.valueobjects;

import com.example.dddleaning.domain.valueobjects.base.ValueObject;

public  class Price extends ValueObject<Double> {
    public Price(final  Double price) {
        if (value == null) {
            throw new IllegalArgumentException("The price should not be null");
        }
        if (value < 0.0) {
            throw new IllegalArgumentException("The price cannot be negative");
        }
        this.value = value;
    }
    public Price(final String value) {
        if (value == null) {
            throw new IllegalArgumentException("Id should not be null");
        }
        if (!value.matches("\\d+(.\\d+)")) {
            throw new IllegalArgumentException("Id should be a double");
        }
        this.value = Double.parseDouble(value);
    }
    public Double toDouble(){
        return value;
    }
}
