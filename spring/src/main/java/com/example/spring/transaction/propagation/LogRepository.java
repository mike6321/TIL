package com.example.spring.transaction.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LogRepository {

    private final EntityManager entityManager;

    @Transactional
    public void saveV1(Log logMessage) {
        log.info("Log 저장");
        entityManager.persist(logMessage);
        if (logMessage.getMessage().contains("로그예외")) {
            log.info("Log 저장 시 예외 발생");
            throw new RuntimeException("예외 발생");
        }
    }

    public void saveV2(Log logMessage) {
        log.info("Log 저장");
        entityManager.persist(logMessage);
        if (logMessage.getMessage().contains("로그예외")) {
            log.info("Log 저장 시 예외 발생");
            throw new RuntimeException("예외 발생");
        }
    }

    @Transactional
    public void saveV3(Log logMessage) {
        log.info("Log 저장");
        entityManager.persist(logMessage);
        if (logMessage.getMessage().contains("로그예외")) {
            log.info("Log 저장 시 예외 발생");
            throw new RuntimeException("예외 발생");
        }
    }

    @Transactional
    public void saveV4(Log logMessage) {
        log.info("Log 저장");
        entityManager.persist(logMessage);
        if (logMessage.getMessage().contains("로그예외")) {
            log.info("Log 저장 시 예외 발생");
            throw new RuntimeException("예외 발생");
        }
    }

    @Transactional
    public void saveV5(Log logMessage) {
        log.info("Log 저장");
        entityManager.persist(logMessage);
        if (logMessage.getMessage().contains("로그예외")) {
            log.info("Log 저장 시 예외 발생");
            throw new RuntimeException("예외 발생");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveV6(Log logMessage) {
        log.info("Log 저장");
        entityManager.persist(logMessage);
        if (logMessage.getMessage().contains("로그예외")) {
            log.info("Log 저장 시 예외 발생");
            throw new RuntimeException("예외 발생");
        }
    }

    public Optional<Log> find(String message) {
        return entityManager.createQuery("select l from Log l where l.message = :message", Log.class)
                .setParameter("message", message)
                .getResultList()
                .stream()
                .findAny();
    }

}
