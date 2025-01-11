package com.example.java.generic.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeRef<T> {

    private final Type type;

    protected TypeRef() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = superclass.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TypeRef && type.equals(((TypeRef) obj).type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    public Type getType() {
        return type;
    }

}
