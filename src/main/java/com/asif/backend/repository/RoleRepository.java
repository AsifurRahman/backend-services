package com.asif.backend.repository;

import com.asif.backend.generic.repository.AbstractRepository;
import com.asif.backend.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends AbstractRepository<Role> {

    Optional<Role> findByNameIgnoreCase(String name);
}
