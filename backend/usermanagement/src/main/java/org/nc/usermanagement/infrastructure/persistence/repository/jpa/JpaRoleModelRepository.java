package org.nc.usermanagement.infrastructure.persistence.repository.jpa;

import org.nc.usermanagement.infrastructure.persistence.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoleModelRepository extends JpaRepository<RoleModel, String> {
    Optional<RoleModel> findByUuid(String uuid);
}
