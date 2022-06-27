package com.example.dto;

import com.example.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResCreateMember {

    private String email;
    private String password;

    public static ResCreateMember of(Member member) {
        return ResCreateMember.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }

}
