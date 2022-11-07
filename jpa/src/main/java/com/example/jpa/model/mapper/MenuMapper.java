package com.example.jpa.model.mapper;

import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.response.MenuResponse;
import com.example.jpa.model.dto.response.MenuResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class MenuMapper {

    public static MenuResponse of(Restaurant restaurant) {
        List<MenuResponseDto> menuResponseDtoList = convertMenuDto(restaurant);
        return MenuResponse.builder()
                .id(restaurant.getId())
                .menuDtoList(menuResponseDtoList)
                .build();
    }

    public static List<MenuResponseDto> convertMenuDto(Restaurant restaurant) {
        return restaurant.getMenus()
                .stream()
                .map(menu -> MenuResponseDto.builder()
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

}
