package org.nc.usermanagement.application.usecases.user.read.exception;

public class UserNotFoundException extends ReadUserException{

    public UserNotFoundException() {
        super("userManagement.useCase.readRole.roleNotFound");
    }
    public UserNotFoundException(String code) {
        super(code);
    }

    public UserNotFoundException(Exception exception) {
        super(exception);
    }
}
