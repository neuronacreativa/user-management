package org.nc.usermanagement.application.usecases.role.delete.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.role.RoleName;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class DeleteRoleByRoleNameIn {

    private final RoleName roleName;

    public DeleteRoleByRoleNameIn(String roleName) throws ValueObjectException {
        this.roleName = new RoleName(roleName);
    }

    public RoleName getRoleName() {
        return roleName;
    }
}
