package com.example.jpa.service;

import com.example.jpa.entity.Menu;
import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.response.ReviewResponse;
import com.example.jpa.model.mapper.ReviewResponseMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final RestaurantRepository restaurantRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Transactional
    public ReviewResponse getReview(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow();

        PersistenceUnitUtil persistenceUnitUtil = entityManagerFactory.getPersistenceUnitUtil();
        boolean isLoadedRestaurantMoreInformation = persistenceUnitUtil.isLoaded(restaurant.getRestaurantMoreInformation());
        System.out.println("isLoadedRestaurantMoreInformation = " + isLoadedRestaurantMoreInformation);
        Set<Menu> menus = restaurant.getMenus();
        boolean isLoadedMenus = persistenceUnitUtil.isLoaded(restaurant.getMenus());
        System.out.println("isLoadedMenus = " + isLoadedMenus);

        return ReviewResponseMapper.of(restaurant);
    }

//    public Restaurant getReview(Long id) {
//        Restaurant restaurant = restaurantRepository.findById(id)
//                .orElseThrow();
//        RestaurantMoreInformation restaurantMoreInformation = restaurant.getRestaurantMoreInformation();
//        return restaurant;
//    }

}
