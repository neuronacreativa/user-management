package org.nc.usermanagement.domain.valueObjects.role;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoleName implements ValueObject<RoleName> {

    private final String roleName;
    private static final int CHAR_LIMIT = 20;
    private static final String regex = "([A-Z.\\-_0-9])+";

    public RoleName(String roleName) throws ValueObjectException {
        isValid(roleName);
        this.roleName = roleName;
    }

    private void isValid(String roleName) throws ValueObjectException {
        if (roleName.length() > CHAR_LIMIT) {
            throw new ValueObjectException("userManagement.valueObject.ko.roleName.charLimitExceeded");
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(roleName);
        if (!matcher.matches()) {
            throw new ValueObjectException("userManagement.valueObject.ko.roleName.invalidString");
        }
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public boolean sameValueAs(RoleName other) {
        return false;
    }
}
