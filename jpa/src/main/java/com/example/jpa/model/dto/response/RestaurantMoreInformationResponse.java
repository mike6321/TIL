package com.example.jpa.model.dto.response;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantMoreInformationResponse {

    private String businessProprietor;
    private String address;
    private String telephone;

}
