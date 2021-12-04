package org.nc.usermanagement.application.usecases.role.create;

import org.nc.usermanagement.application.usecases.UseCaseException;

public class CreateRoleException extends UseCaseException {

    public CreateRoleException(String message) {
        super(message);
    }
}
