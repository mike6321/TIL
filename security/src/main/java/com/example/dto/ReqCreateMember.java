package com.example.dto;

import lombok.Getter;

@Getter
public class ReqCreateMember {

    private String email;
    private String password;

    public void encodePassword(String password) {
        this.password = password;
    }

}
