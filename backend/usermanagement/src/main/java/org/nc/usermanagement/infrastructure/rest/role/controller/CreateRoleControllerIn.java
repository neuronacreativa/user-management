package org.nc.usermanagement.infrastructure.rest.role.controller;

import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class CreateRoleControllerIn {

    private final String roleName;
    private final int priority;

    public CreateRoleControllerIn(String roleName, int priority) {
        this.roleName = roleName;
        this.priority = priority;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getPriority() {
        return priority;
    }
}
