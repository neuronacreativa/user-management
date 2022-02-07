package org.nc.usermanagement.application.usecases.user.read.exception;

public class UserIsEmptyException extends ReadUserException{

    public UserIsEmptyException() {
        super("userManagement.useCase.readRole.userIsEmpty");
    }
    public UserIsEmptyException(String code) {
        super(code);
    }

    public UserIsEmptyException(Exception exception) {
        super(exception);
    }
}
