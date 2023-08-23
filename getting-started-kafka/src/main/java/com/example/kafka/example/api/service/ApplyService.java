package com.example.kafka.example.api.service;


import com.example.kafka.example.api.producer.CouponCreateProducer;
import com.example.kafka.example.api.repository.CouponCountRepository;
import com.example.kafka.example.api.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;

    public void apply(Long userId) {
        long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }

        couponCreateProducer.create(userId);
//        couponRepository.save(new Coupon(userId));
    }

}
