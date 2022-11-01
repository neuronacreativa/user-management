package org.nc.usermanagement.application.usecases.role.read.exception;


public class RoleNotFoundException extends ReadRoleException {

    public RoleNotFoundException() {
        super("userManagement.useCase.createRole.roleNotFound");
    }

    public RoleNotFoundException(Exception exception) {
        super(exception);
    }
}
