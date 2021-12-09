package org.nc.usermanagement.domain.exception;

public class DomainException extends Exception {
    public DomainException(String code) {
        super(code);
    }
    public DomainException(Exception e) {
        super(e);
    }
}
