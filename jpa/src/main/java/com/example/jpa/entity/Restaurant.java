package com.example.jpa.entity;

import com.example.jpa.model.dto.request.RestaurantRequest;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_name")
    private String companyName;

    /**
     * OneToOne 는 Proxy 객체를 사용한다.
     * 즉시 데이터를 가져오지 않고 직접적으로 해당 객체 대한 내용을 찾을 때
     * 비로소 가져온다.
     * */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "restaurant_more_information_id")
    private RestaurantMoreInformation restaurantMoreInformation;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "restaurant_id")
    private Set<Reservation> reservations;

    /**
     * OneToMany 는 Proxy 객체를 사용하지 않는다.
     * Persistence Bag
     * Persistence Set
     * 을 활용하여
     * 즉시 데이터를 가져온다.
     * */
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private Set<Menu> menus;

    public static Restaurant of(RestaurantRequest restaurantRequest) {
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .companyName(restaurantRequest.getCompanyName())
                .build();
    }

    public void createMenu(Set<Menu> menus) {
        this.menus.addAll(menus);
    }

    public void createMoreInformation(RestaurantMoreInformation restaurantMoreInformation) {
        this.restaurantMoreInformation = restaurantMoreInformation;
    }

    public void setName(String name) {
        this.name = name;
    }
}
