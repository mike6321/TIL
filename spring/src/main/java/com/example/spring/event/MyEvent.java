package com.example.spring.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MyEvent {

    private final Object source;
    private final int data;

}
