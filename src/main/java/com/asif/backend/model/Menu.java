package com.asif.backend.model;

import com.asif.backend.generic.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menus")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends BaseEntity {

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isMenu = false;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isModule = false;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isParent = false;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean showSideBar = false;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean showPage = false;

    private String displayName;

    private String url;

    private Long parentId;

    private Integer sortId;
}
