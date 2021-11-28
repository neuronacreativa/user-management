package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.shared.Entity;

public class Role implements Entity<Role> {
    @Override
    public boolean sameIdentityAs(Role other) {
        return false;
    }
}
