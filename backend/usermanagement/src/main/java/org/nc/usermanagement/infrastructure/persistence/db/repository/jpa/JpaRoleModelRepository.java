package org.nc.usermanagement.infrastructure.persistence.db.repository.jpa;

import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoleModelRepository extends JpaRepository<RoleModel, String> {
    Optional<RoleModel> findByUuid(String uuid);
    Optional<RoleModel> findByRoleName(String roleName);
}
