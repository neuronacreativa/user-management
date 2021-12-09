package org.nc.usermanagement.application.usecases.role;

import org.nc.usermanagement.application.usecases.role.create.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.ReadRoleException;
import org.nc.usermanagement.application.usecases.role.read.RoleNotFoundException;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public interface RoleRepository {
    void save(Role role) throws CreateRoleException;
    Role findByUuid(String uuid) throws EntityException, ValueObjectException, ReadRoleException;
    void delete(Role role);
}
