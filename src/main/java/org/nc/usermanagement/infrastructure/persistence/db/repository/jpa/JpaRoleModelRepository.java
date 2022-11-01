package org.nc.usermanagement.infrastructure.persistence.db.repository.jpa;

import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaRoleModelRepository extends PagingAndSortingRepository<RoleModel, Integer> {
    Optional<RoleModel> findByUuid(String uuid);
    List<RoleModel> findByUuidIn(List<String> uuids);
    Optional<RoleModel> findByRoleName(String roleName);
}
