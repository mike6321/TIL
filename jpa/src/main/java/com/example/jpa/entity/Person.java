package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Table(name = "person")
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Generated(GenerationTime.INSERT)
    private Integer idColumn;

    @EmbeddedId
    private PersonId personId;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name", updatable = false, insertable = false)
    private String name;
    @Column(name = "dept_no", updatable = false, insertable = false)
    private Integer deptNo;

    public Person(PersonId personId, String phoneNumber) {
        this.personId = personId;
        this.phoneNumber = phoneNumber;
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    public static class PersonId implements Serializable {

        @Column(name = "name")
        private String name;
        @Column(name = "dept_no")
        private Integer deptNo;

    }
}
