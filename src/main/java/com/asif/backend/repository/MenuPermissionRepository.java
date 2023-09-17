package com.asif.backend.repository;

import com.asif.backend.generic.repository.AbstractRepository;
import com.asif.backend.model.MenuPermission;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuPermissionRepository extends AbstractRepository<MenuPermission> {

    Optional<MenuPermission> findByRoleId(Long roleId);
}
