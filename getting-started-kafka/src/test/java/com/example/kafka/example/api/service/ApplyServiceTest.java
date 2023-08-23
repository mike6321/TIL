package com.example.kafka.example.api.service;

import com.example.kafka.example.api.repository.CouponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplyServiceTest {
    @Autowired
    private ApplyService applyService;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void 한번만응모() {
        applyService.apply(1L);

        long count = couponRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void 여러명응모() throws InterruptedException {

        int threadCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        applyService.apply(1L);

//        for (int i = 0; i < threadCount; i++) {
//            long userId = i;
//            executorService.submit(() -> {
//                try {
//                    applyService.apply(userId);
//                } finally {
//                    countDownLatch.countDown();
//                }
//            });
//        }
//
//        countDownLatch.await();
//
//        long count = couponRepository.count();
//
//        assertThat(count).isEqualTo(100);
    }

    @BeforeEach
    void refresh() {
        couponRepository.deleteAll();
        redisTemplate.execute((RedisConnection connection) -> {
            connection.serverCommands().flushDb();
            return "OK";
        });
    }

}
