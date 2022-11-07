package com.example.jpa.entity;

import com.example.jpa.model.dto.request.RestaurantMoreInformationRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "restaurant_more_information")
public class RestaurantMoreInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_more_information_id")
    private Long id;

    @Column(name = "business_proprietor")
    private String businessProprietor;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    public static RestaurantMoreInformation of(RestaurantMoreInformationRequest restaurantMoreInformationRequest) {
        return RestaurantMoreInformation.builder()
                .businessProprietor(restaurantMoreInformationRequest.getBusinessProprietor())
                .address(restaurantMoreInformationRequest.getAddress())
                .telephone(restaurantMoreInformationRequest.getTelephone())
                .build();
    }

}
