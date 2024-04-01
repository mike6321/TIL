package com.example.jpa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LockInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Object[]> getLockInfo() {
        String sql = "SELECT request_session_id, request_mode FROM sys.dm_tran_locks WHERE resource_database_id = DB_ID()";
        return entityManager.createNativeQuery(sql).getResultList();
    }
}
