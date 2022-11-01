package org.nc.usermanagement.application.usecases.role.create.exception;

public class RoleAlreadyExistsException extends CreateRoleException{
    public RoleAlreadyExistsException() {
        super("userManagement.useCase.createRole.roleNameAlreadyExists");
    }
}
