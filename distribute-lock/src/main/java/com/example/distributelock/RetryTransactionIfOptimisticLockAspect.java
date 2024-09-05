package com.example.distributelock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Order(Ordered.LOWEST_PRECEDENCE - 2)
@Aspect
@Component
public class RetryTransactionIfOptimisticLockAspect {

    @Around("@annotation(com.example.distributelock.RetryTransactionIfOptimisticLockException)")
    public Object retry(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        for (int i = 0; i < 3; i++) {
            System.out.println("(RetryTransactionIfOptimisticLockAspect) !!!!");
            try {
                return proceedingJoinPoint.proceed();
            } catch (CustomException e) {
                System.out.println("재시도 처리");
            }
        }
        return null;
    }

}
