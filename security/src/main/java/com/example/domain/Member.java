package com.example.domain;

import com.example.dto.ReqCreateMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id")
    private Grade grade;
    @Column(name = "password", length = 100)
    private String password;

    public static Member createMember(ReqCreateMember reqCreateMember) {
        return Member
                .builder()
                .email(reqCreateMember.getEmail())
                .password(reqCreateMember.getPassword())
                .grade(Grade.createBeginnerGrade())
                .build();
    }

}
