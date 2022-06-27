package com.example.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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

}
