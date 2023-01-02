package com.example.enum_converter.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MenuType {

    MAIN_DISH(1),
    SIDE_DISH(2);

    private static final Map<Integer, MenuType> valueMap;

    static {
        valueMap = Arrays.stream(MenuType.values())
                .collect(Collectors.toMap(MenuType::getCode, Function.identity()));
    }

    private Integer code;

    MenuType(Integer code) {
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public static MenuType get(int value) {
        return Optional.ofNullable(valueMap.get(value))
                .orElseThrow(() -> new IllegalArgumentException("cannot find a value, " + value));

    }

}
