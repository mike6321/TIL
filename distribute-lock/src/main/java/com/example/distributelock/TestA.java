package com.example.distributelock;

import org.springframework.stereotype.Service;

@Service
public class TestA {

    @RetryTransactionIfOptimisticLockException
    @DistributedLock
    public void test() {
        System.out.println("running...!");
    }

}
