package com.example.version.V_2_1.log_group;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private String isbn;

    private String title;

}
