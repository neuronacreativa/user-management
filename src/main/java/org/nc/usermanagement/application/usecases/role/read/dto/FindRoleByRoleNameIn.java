package org.nc.usermanagement.application.usecases.role.read.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.role.RoleName;

public class FindRoleByRoleNameIn {

    private final RoleName roleName;

    public FindRoleByRoleNameIn(String roleName) throws ValueObjectException {
        this.roleName = new RoleName(roleName);
    }

    public RoleName getRoleName() {
        return roleName;
    }
}
