package com.example.jpa.service;

import com.example.jpa.entity.Restaurant;
import com.example.jpa.entity.RestaurantMoreInformation;
import com.example.jpa.model.dto.request.RestaurantMoreInformationRequest;
import com.example.jpa.model.dto.response.RestaurantMoreInformationResponse;
import com.example.jpa.model.mapper.RestaurantMoreInformationMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantMoreInformationService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public RestaurantMoreInformationResponse createMoreInformation(RestaurantMoreInformationRequest restaurantMoreInformationRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantMoreInformationRequest.getId())
                .orElseThrow();

        restaurant.createMoreInformation(RestaurantMoreInformation.of(restaurantMoreInformationRequest));

        return RestaurantMoreInformationMapper.of(restaurant);
    }
}
