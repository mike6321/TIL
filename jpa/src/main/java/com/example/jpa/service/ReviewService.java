package com.example.jpa.service;

import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.response.ReviewResponse;
import com.example.jpa.model.mapper.ReviewResponseMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final RestaurantRepository restaurantRepository;

    public ReviewResponse getReview(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow();

        return ReviewResponseMapper.of(restaurant);
    }

}
