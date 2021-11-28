package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.shared.Entity;

public class AuthenticationType implements Entity<AuthenticationType> {
    @Override
    public boolean sameIdentityAs(AuthenticationType other) {
        return false;
    }
}
