package org.nc.usermanagement.domain.valueObjects.role;

import org.nc.usermanagement.domain.shared.Entity;

public class RoleName implements Entity<RoleName> {
    @Override
    public boolean sameIdentityAs(RoleName other) {
        return false;
    }
}
