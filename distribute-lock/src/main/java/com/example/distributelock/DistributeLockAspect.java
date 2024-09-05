package com.example.distributelock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Aspect
@Component
public class DistributeLockAspect {

    @Around("@annotation(com.example.distributelock.DistributedLock)")
    public Object retry(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        if (true) {
//            throw new CustomException("test error...!");
//        }
        return proceedingJoinPoint.proceed();
    }

}
