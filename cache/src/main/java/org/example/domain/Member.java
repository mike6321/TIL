package org.example.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@ToString
@Getter
@Table("members")
public class Member {

    @Id
    @Column("member_id")
    private Long id;

    @Column("user_code")
    private String userCode;

    @Column("join_at")
    private LocalDateTime joinAt;

    protected Member() {
    }

    public Member(String userCode) {
        this.id = PrimaryKey.generate();
        this.userCode = userCode;
        this.joinAt = LocalDateTime.now();
    }

    public Member(String userCode, LocalDateTime joinAt) {
        this.id = PrimaryKey.generate();
        this.userCode = userCode;
        this.joinAt = joinAt;
    }
}
