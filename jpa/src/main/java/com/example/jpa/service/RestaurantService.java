package com.example.jpa.service;


import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.request.RestaurantRequest;
import com.example.jpa.model.dto.response.RestaurantResponse;
import com.example.jpa.model.mapper.RestaurantMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final LockInfoService lockInfoService;
    @PersistenceContext
    private EntityManager entityManager;

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(Restaurant.of(restaurantRequest));
        return RestaurantMapper.of(restaurant);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public RestaurantResponse getRestaurant(Long id) {
        Restaurant restaurant = null;
        for (int i = 0; i < 100000; i++) {
            restaurant = restaurantRepository.findById(id).orElseThrow();
            lockInfoService.printLockInfo();
        }
//        try {
//            Thread.sleep(100000l);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return RestaurantMapper.of(restaurant);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public RestaurantResponse updateRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();
        lockInfoService.printLockInfo();

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return RestaurantMapper.of(restaurant);
    }

//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public RestaurantResponse updateRestaurant(Long id) {
//        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();
//
//        try {
//            restaurant.setName("READ_UNCOMMITTED");
//            Thread.sleep(10000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        return RestaurantMapper.of(restaurant);
//    }

}
