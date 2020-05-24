package com.example.dddleaning.domain.entities;

import java.util.Objects;

public abstract class EntityBase<T extends EntityBase<T>> {
private Long id;
public  Long getId(){
    return id;
}
private  boolean sameIdentityAs(final T that){
    return  this.equals(that);
}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EntityBase)) {
            return false;
        }
        final EntityBase<?> that = (EntityBase<?>) o;
        _checkIdentity(this);
        _checkIdentity(that);
        return this.id.equals(that.getId());
    }
    private void _checkIdentity(final EntityBase<?> entity) {
        if (entity.getId() == null) {
            throw new IllegalStateException("Identity missing in entity: " + entity);
        }
    }
    @Override
    public int hashCode() {
        return getId()!=null ?getId().hashCode():0;
    }
}
