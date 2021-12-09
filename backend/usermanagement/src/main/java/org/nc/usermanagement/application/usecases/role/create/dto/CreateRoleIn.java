package org.nc.usermanagement.application.usecases.role.create.dto;

import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.UUID;

public class CreateRoleIn {
    private final Role role;

    public CreateRoleIn(String roleName, int priority) throws EntityException, ValueObjectException {
        this.role = new Role(
                UUID.randomUUID().toString(),
                roleName,
                priority
        );
    }

    public Role getRole() {
        return role;
    }
}
