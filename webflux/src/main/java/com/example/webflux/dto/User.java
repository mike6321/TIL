package com.example.webflux.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Builder
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final AtomicLong sequence = new AtomicLong(1L);

    public static User createUser(String name, String email) {
        return User.builder()
                .name(name)
                .email(email)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
