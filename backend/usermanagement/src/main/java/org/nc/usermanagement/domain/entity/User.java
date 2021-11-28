package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.shared.Entity;

public class User implements Entity<User> {
    @Override
    public boolean sameIdentityAs(User other) {
        return false;
    }
}
