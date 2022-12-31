package com.example.enum_converter.converter;

import com.example.enum_converter.enums.MenuType;

import javax.persistence.AttributeConverter;

public class MenuTypeConverter implements AttributeConverter<MenuType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MenuType attribute) {
        if (attribute == null) {
            new IllegalArgumentException("MenuType must not be null");
        }

        return attribute.getCode();
    }

    @Override
    public MenuType convertToEntityAttribute(Integer dbData) {
        return MenuType.get(dbData);
    }

}
