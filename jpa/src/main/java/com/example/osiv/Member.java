package com.example.osiv;

import com.example.osiv.dto.MemberRequest;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Set<Team> teams;

    public static Member of(MemberRequest memberRequest) {
        return Member.builder()
                .name(memberRequest.getName())
                .build();
    }

    public void createTeam(Set<Team> teams) {
        this.teams.addAll(Collections.unmodifiableSet(teams));
    }

}
