package com.example.jpa.model.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class MenuRequest {

    private Long id;
    private List<MenuDto> menuDtoList;

}
