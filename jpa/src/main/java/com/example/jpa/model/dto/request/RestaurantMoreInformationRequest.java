package com.example.jpa.model.dto.request;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantMoreInformationRequest {

    private Long id;
    private String businessProprietor;
    private String address;
    private String telephone;

}
