package org.nc.usermanagement.application.usecases.role.update.dto;

import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class UpdateRoleIn {

    private final Role role;

    public UpdateRoleIn(String uuid, String roleName, int priority) throws ValueObjectException, EntityException {
        this.role = new Role(
            uuid,
            roleName,
            priority
        );
    }

    public Role getRole() {
        return role;
    }
}
