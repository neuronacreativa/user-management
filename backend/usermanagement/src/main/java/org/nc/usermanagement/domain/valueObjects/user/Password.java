package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.ValueObject;

public class Password implements ValueObject<Password> {

    private final String password;
    private static final int CHAR_LIMIT = 20;
    // TODO: Add regex characters validation

    public Password(String password) throws DomainException {
        isValid(password);
        this.password = password;
    }

    private void isValid(String password) throws DomainException {
        if (password.length() > CHAR_LIMIT) {
            throw new DomainException("This is a Domain Exception");
        }
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean sameValueAs(Password other) {
        return false;
    }
}
