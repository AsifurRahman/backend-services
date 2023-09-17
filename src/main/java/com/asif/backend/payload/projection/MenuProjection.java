package com.asif.backend.payload.projection;

public interface MenuProjection {
    Long getId();

    Boolean getIsModule();

    Boolean getIsParent();

    Boolean getShowSideBar();

    Boolean getShowPage();

    String getDisplayName();

    String getUrl();

    Long getParentId();

    Integer getSortId();
}
