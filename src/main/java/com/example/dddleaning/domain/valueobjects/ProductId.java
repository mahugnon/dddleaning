package com.example.dddleaning.domain.valueobjects;

import com.example.dddleaning.domain.valueobjects.base.ValueObject;

public final class ProductId extends ValueObject<Long> {

    public ProductId(final Long id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Id should not be null");
        }
        this.value = id;
    }

    public ProductId(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id should not be null");
        }
        if (!id.matches("\\d+")) {
            throw new IllegalArgumentException("Id should be a number");
        }
        this.value = Long.parseLong(id);
    }

    public Long toLong() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }
}

