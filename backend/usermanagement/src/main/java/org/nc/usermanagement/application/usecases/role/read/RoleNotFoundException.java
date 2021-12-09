package org.nc.usermanagement.application.usecases.role.read;


public class RoleNotFoundException extends ReadRoleException {

    public RoleNotFoundException() {
        super("userManagement.usecase.ko.role.roleNotFound");
    }

    public RoleNotFoundException(Exception exception) {
        super(exception);
    }
}
