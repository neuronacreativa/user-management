package org.nc.usermanagement.application.usecases.role;

import org.nc.usermanagement.application.usecases.role.create.CreateRoleException;
import org.nc.usermanagement.domain.entity.Role;

public interface RoleRepository {
    void save(Role role) throws CreateRoleException;
    Role get();
    void delete(Role role);
}
