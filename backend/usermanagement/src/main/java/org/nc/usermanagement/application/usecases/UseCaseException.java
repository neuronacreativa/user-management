package org.nc.usermanagement.application.usecases;

import org.nc.usermanagement.domain.exception.DomainException;

public class UseCaseException extends DomainException {
    public UseCaseException(String code) {
        super(code);
    }
    public UseCaseException(Exception exception) {
        super(exception);
    }
}
