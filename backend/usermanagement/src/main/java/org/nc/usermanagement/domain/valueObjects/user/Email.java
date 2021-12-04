package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.ValueObject;

public class Email implements ValueObject<Email> {

    private final String email;
    private static final int CHAR_LIMIT = 100;
    // TODO: Add regex characters validation

    public Email(String email) throws DomainException {
        isValid(email);
        this.email = email;
    }

    private void isValid(String email) throws DomainException {
        if (email.length() > CHAR_LIMIT) {
            throw new DomainException("This is a Domain Exception");
        }
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean sameValueAs(Email other) {
        return this.getEmail().equals(other.getEmail());
    }
}
