package com.example.spring.dynamic_proxy;

import lombok.Getter;

@Getter
public class Book {

    private final String title;

    public Book(String title) {
        this.title = title;
    }

}
