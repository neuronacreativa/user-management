package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.shared.Entity;

public class Authentication implements Entity<Authentication> {
    @Override
    public boolean sameIdentityAs(Authentication other) {
        return false;
    }
}
