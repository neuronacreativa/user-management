package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.ValueObject;

public class UserName implements ValueObject<UserName> {

    private final String userName;
    private static final int CHAR_LIMIT = 50;
    // TODO: Add regex char validation

    public UserName(String userName) throws DomainException {
        isValid(userName);
        this.userName = userName;
    }

    private void isValid(String userName) throws DomainException {
        if (userName.length() > CHAR_LIMIT) {
            throw new DomainException("This is a Domain Exception");
        }
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean sameValueAs(UserName other) {
        return this.getUserName().equals(other.getUserName());
    }
}
