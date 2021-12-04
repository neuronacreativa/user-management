package org.nc.usermanagement.domain.valueObjects.role;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.ValueObject;

public class RoleName implements ValueObject<RoleName> {

    private final String roleName;
    private static final int CHAR_LIMIT = 20;
    // TODO: Add regex characters validation

    public RoleName(String roleName) throws DomainException {
        isValid(roleName);
        this.roleName = roleName;
    }

    private void isValid(String roleName) throws DomainException {
        if (roleName.length() > CHAR_LIMIT) {
            throw new DomainException("This is a Domain Exception");
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
