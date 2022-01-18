package org.nc.usermanagement.infrastructure.rest.role.controller.read.dto;

import org.nc.usermanagement.application.usecases.role.read.dto.ReadByRoleNameIn;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindRoleByRoleNameControllerIn {

    private final ReadByRoleNameIn readByRoleNameIn;

    public FindRoleByRoleNameControllerIn(String roleName) throws ValueObjectException {
        this.readByRoleNameIn = new ReadByRoleNameIn(
                roleName
        );
    }

    public ReadByRoleNameIn getReadByRoleNameIn() {
        return readByRoleNameIn;
    }
}
