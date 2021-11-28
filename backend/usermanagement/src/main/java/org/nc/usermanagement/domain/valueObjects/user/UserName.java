package org.nc.usermanagement.domain.valueObjects.user;

import org.nc.usermanagement.domain.shared.Entity;

public class UserName implements Entity<UserName> {
    @Override
    public boolean sameIdentityAs(UserName other) {
        return false;
    }
}
