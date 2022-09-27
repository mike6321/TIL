package com.example.spring.bean.generic_bean.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChildB extends Parent {

    private Long id;
    private String option1;

}
