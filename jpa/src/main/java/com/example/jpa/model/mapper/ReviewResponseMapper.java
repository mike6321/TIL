package com.example.jpa.model.mapper;

import com.example.jpa.entity.Menu;
import com.example.jpa.entity.Restaurant;
import com.example.jpa.entity.RestaurantMoreInformation;
import com.example.jpa.model.dto.response.ReviewResponse;

import java.util.Set;

public class ReviewResponseMapper {

    public static ReviewResponse of(Restaurant restaurant) {
        Set<Menu> menus = restaurant.getMenus();
        RestaurantMoreInformation restaurantMoreInformation = restaurant.getRestaurantMoreInformation();
        String address = restaurantMoreInformation.getAddress();

        return ReviewResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .companyName(restaurant.getCompanyName())
                .menu(menus == null ? null : MenuMapper.of(restaurant))
                .restaurantMoreInformation(restaurantMoreInformation == null ? null : RestaurantMoreInformationMapper.of(restaurant))
                .build();
    }

}
