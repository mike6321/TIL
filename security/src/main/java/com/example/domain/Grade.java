package com.example.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue
    @Column(name = "grade_id")
    private Long id;
    @Column(name = "grade_status")
    @Enumerated(EnumType.STRING)
    private GradeStatus gradeStatus;

}
