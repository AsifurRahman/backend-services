package com.asif.backend.model;

import com.asif.backend.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "menu_permissions")
@AllArgsConstructor
@NoArgsConstructor
public class MenuPermission extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "role_id", insertable = false, updatable = false)
    private Long roleId;

    @ManyToMany
    @JoinTable(
            name = "menu_permission_mapping",
            joinColumns = {@JoinColumn(name = "menu_permissions_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id")}
    )
    private Set<Menu> menuSet = new HashSet<>();
}
