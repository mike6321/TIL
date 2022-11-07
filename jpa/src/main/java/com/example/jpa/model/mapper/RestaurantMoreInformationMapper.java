package com.example.jpa.model.mapper;

import com.example.jpa.entity.Restaurant;
import com.example.jpa.entity.RestaurantMoreInformation;
import com.example.jpa.model.dto.response.RestaurantMoreInformationResponse;

public class RestaurantMoreInformationMapper {

    public static RestaurantMoreInformationResponse of(Restaurant restaurant) {
        RestaurantMoreInformation restaurantMoreInformation = restaurant.getRestaurantMoreInformation();

        return RestaurantMoreInformationResponse.builder()
                .businessProprietor(restaurantMoreInformation.getBusinessProprietor())
                .address(restaurantMoreInformation.getAddress())
                .telephone(restaurantMoreInformation.getTelephone())
                .build();
    }

}
