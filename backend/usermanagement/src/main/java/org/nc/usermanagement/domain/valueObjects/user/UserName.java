package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserName implements ValueObject<UserName> {

    private final String userName;
    private static final int CHAR_LIMIT = 50;
    private static final String regex = "([A-Z.a-z-_0-9])+";

    public UserName(String userName) throws ValueObjectException {
        isValid(userName);
        this.userName = userName;
    }

    private void isValid(String userName) throws ValueObjectException {
        if (userName.length() > CHAR_LIMIT) {
            throw new ValueObjectException("userManagement.valueObject.ko.userName.charLimitExceeded");
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userName);
        if (!matcher.matches()) {
            throw new ValueObjectException("userManagement.valueObject.ko.userName.invalidString");
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
