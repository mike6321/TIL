package com.example.jpa.controller;

import com.example.jpa.model.dto.request.MenuRequest;
import com.example.jpa.model.dto.request.RestaurantMoreInformationRequest;
import com.example.jpa.model.dto.request.RestaurantRequest;
import com.example.jpa.model.dto.response.MenuResponse;
import com.example.jpa.model.dto.response.RestaurantMoreInformationResponse;
import com.example.jpa.model.dto.response.RestaurantResponse;
import com.example.jpa.model.dto.response.ReviewResponse;
import com.example.jpa.service.MenuService;
import com.example.jpa.service.RestaurantMoreInformationService;
import com.example.jpa.service.RestaurantService;
import com.example.jpa.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/restaurant/")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuService menuService;
    private final ReviewService reviewService;
    private final RestaurantMoreInformationService restaurantMoreInformationService;

    @PostMapping
    public RestaurantResponse createRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        return restaurantService.createRestaurant(restaurantRequest);
    }

    @GetMapping("{id}")
    public RestaurantResponse getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PutMapping("{id}")
    public RestaurantResponse updateRestaurant(@PathVariable Long id) {
        return restaurantService.updateRestaurant(id);
    }


    @PostMapping("menu")
    public MenuResponse createMenu(@RequestBody MenuRequest menuRequest) {
        return menuService.createMenu(menuRequest);
    }

    @PostMapping("more-information")
    public RestaurantMoreInformationResponse createMoreInformation(@RequestBody RestaurantMoreInformationRequest restaurantMoreInformationRequest) {
        return restaurantMoreInformationService.createMoreInformation(restaurantMoreInformationRequest);
    }

    @GetMapping("review/{id}")
    public ReviewResponse getAllInformation(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

}
