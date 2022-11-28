package com.example.java.multi_thread.superbuilder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Child extends Parent {

    private String name;

    public static Child of(String name) {
        return Child.builder()
                .id(1L)
                .name(name)
                .build();
    }

}
