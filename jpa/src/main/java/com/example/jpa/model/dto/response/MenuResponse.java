package com.example.jpa.model.dto.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuResponse {

    private Long id;
    private List<MenuResponseDto> menuDtoList;

}
