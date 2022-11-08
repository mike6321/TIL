package com.example.osiv.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TeamRequest {

    private Long id;
    private List<TeamDto> teams;

}
