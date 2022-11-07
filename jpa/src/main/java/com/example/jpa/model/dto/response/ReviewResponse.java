package com.example.jpa.model.dto.response;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponse {

    private Long id;
    private String name;
    private String companyName;
    private MenuResponse menu;
    private RestaurantMoreInformationResponse restaurantMoreInformation;

}
