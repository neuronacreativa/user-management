package org.nc.usermanagement.infrastructure.persistence.db.repository.jpa;

import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoleModelRepository extends PagingAndSortingRepository<RoleModel, Integer> {
    Optional<RoleModel> findByUuid(String uuid);
    Optional<RoleModel> findByRoleName(String roleName);
    Optional<RoleModel> findByUuidAndRoleName(String uuid, String roleName);
    Optional<RoleModel> findByUuidOrRoleName(String uuid, String roleName);
}
