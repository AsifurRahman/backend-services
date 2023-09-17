package com.asif.backend.payload.projection;

import java.util.Set;

public interface MenuPermissionProjection {

    Long getId();

    Long getRoleId();

    Set<MenuProjection> getMenuSet();
}
