package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password implements ValueObject<Password> {

    private final String password;
    private static final int CHAR_LIMIT = 20;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public Password(String password) throws ValueObjectException {
        isValid(password);
        this.password = password;
    }

    private void isValid(String password) throws ValueObjectException {
        if (password.length() > CHAR_LIMIT) {
            throw new ValueObjectException("userManagement.valueObject.ko.password.charLimitExceeded");
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new ValueObjectException("userManagement.valueObject.ko.password.invalidString");
        }
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean sameValueAs(Password other) {
        return this.getPassword().equals(other.getPassword());
    }
}
