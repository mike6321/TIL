package com.example.jpa.model.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantResponse {

    private Long id;
    private String name;
    private String companyName;

}
