package com.example.jpa.service;

import com.example.jpa.entity.Menu;
import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.request.MenuRequest;
import com.example.jpa.model.dto.response.MenuResponse;
import com.example.jpa.model.mapper.MenuMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final RestaurantRepository restaurantRepository;

    // 변경감지를 하는 경우에 @Transactional 어노테이션이 필수
    @Transactional
    public MenuResponse createMenu(MenuRequest menuRequest) {
        Restaurant restaurant = restaurantRepository.findById(menuRequest.getId())
                .orElseThrow();

        Set<Menu> menus = menuRequest.getMenuDtoList()
                .stream()
                .map(Menu::of)
                .collect(Collectors.toSet());

        restaurant.createMenu(menus);

        return MenuMapper.of(restaurant);
    }

}
