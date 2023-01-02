package com.example.enum_converter.entity;


import com.example.enum_converter.converter.MenuTypeConverter;
import com.example.enum_converter.dto.MenuDto;
import com.example.enum_converter.enums.MenuType;
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

    @Column(name = "menu_type")
    @Convert(converter = MenuTypeConverter.class)
    private MenuType menuType;

    public static Menu of(MenuDto menuDto) {
        return Menu.builder()
                .menuType(menuDto.getMenuType())
                .build();
    }

}
