package net.fashiongo.api.common.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class AuditEntity {

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createBy;

    @CreatedDate
    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @PrePersist
    public void onCreation() {
        this.createdOn = LocalDateTime.now();
        this.modifiedOn = this.createdOn;
        this.createBy = "TEST";
        this.modifiedBy = this.createBy;
    }

    @PreUpdate
    public void onUpdate() {
        this.modifiedOn = LocalDateTime.now();
        this.modifiedBy = "TEST";
    }
}
