package com.example.jpa.model.dto.response;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuResponseDto {

    private String name;
    private Long price;

}
