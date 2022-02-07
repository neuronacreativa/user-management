package org.nc.usermanagement.application.usecases.user.read.exception;

import org.nc.usermanagement.application.usecases.UseCaseException;

public class ReadUserException extends UseCaseException {

    public ReadUserException(String code) {
        super(code);
    }

    public ReadUserException(Exception exception) {
        super(exception);
    }
}
