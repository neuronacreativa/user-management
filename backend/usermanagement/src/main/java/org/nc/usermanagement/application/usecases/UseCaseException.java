package org.nc.usermanagement.application.usecases;

import org.nc.usermanagement.domain.exception.ValueObjectException;

public class UseCaseException extends ValueObjectException {
    public UseCaseException(String message) {
        super(message);
    }
}
