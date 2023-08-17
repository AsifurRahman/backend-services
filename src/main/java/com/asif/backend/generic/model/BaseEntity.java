package com.asif.backend.generic.model;

import com.asif.backend.common.Utils.Helper;
import com.asif.backend.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    private User updatedBy;

    private Boolean isActive;

    @PrePersist
    private void onBasePersist() {
        User user = Helper.getCurrentUser();
        if (user != null && this.createdBy == null) {
            this.createdBy = user;
        }
        this.isActive = true;
    }


    @PreUpdate
    private void onBaseUpdate() {
        User user = Helper.getCurrentUser();
        if (user != null) {
            this.updatedBy = user;
        } else {
            this.updatedBy = this.createdBy;
        }
    }

}
