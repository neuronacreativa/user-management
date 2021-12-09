package org.nc.usermanagement.application.usecases.role.read;

import org.nc.usermanagement.application.usecases.UseCaseException;

public class ReadRoleException extends UseCaseException {

    public ReadRoleException(String code) {
        super(code);
    }

    public ReadRoleException(Exception exception) {
        super(exception);
    }
}
