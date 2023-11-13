package org.example.repository;

import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class InsertableRepositoryImpl<T> implements InsertableRepository<T> {

    private final JdbcAggregateOperations entityOperations;

    public InsertableRepositoryImpl(JdbcAggregateOperations entityOperations) {
        this.entityOperations = entityOperations;
    }

    @Override
    @Transactional
    public <S extends T> S insert(S entity) {
        return entityOperations.insert(entity);
    }
}
