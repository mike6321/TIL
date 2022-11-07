package com.example.jpa.model.mapper;

import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.response.RestaurantResponse;

public class RestaurantMapper {

    public static RestaurantResponse of(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .companyName(restaurant.getCompanyName())
                .build();
    }

}
