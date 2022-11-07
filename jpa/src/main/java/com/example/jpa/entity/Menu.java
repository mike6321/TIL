package com.example.jpa.entity;


import com.example.jpa.model.dto.request.MenuDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    public static Menu of(MenuDto menuDto) {
        return Menu.builder()
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .build();
    }

}
