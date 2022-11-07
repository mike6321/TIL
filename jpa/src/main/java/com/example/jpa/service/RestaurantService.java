package com.example.jpa.service;


import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.request.RestaurantRequest;
import com.example.jpa.model.dto.response.RestaurantResponse;
import com.example.jpa.model.mapper.RestaurantMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(Restaurant.of(restaurantRequest));
        return RestaurantMapper.of(restaurant);
    }

}
