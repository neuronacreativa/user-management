package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements ValueObject<Email> {

    private final String email;
    private static final String regex = "^(.+)@(.+)$";
    private static final int CHAR_LIMIT = 100;

    public Email(String email) throws ValueObjectException {
        isValid(email);
        this.email = email;
    }

    private void isValid(String email) throws ValueObjectException {
        if (email.length() > CHAR_LIMIT) {
            throw new ValueObjectException("userManagement.valueObject.ko.email.charLimitExceeded");
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ValueObjectException("userManagement.valueObject.ko.email.invalidString");
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
