package com.example.webflux.dto;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String name;
    private String email;

}
