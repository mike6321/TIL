package org.example.repository;

public interface InsertableRepository<T> {

    <S extends T> S insert(S entity);

}
