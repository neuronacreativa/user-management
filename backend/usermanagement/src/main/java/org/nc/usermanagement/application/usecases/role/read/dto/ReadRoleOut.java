package org.nc.usermanagement.application.usecases.role.read.dto;

import org.nc.usermanagement.domain.entity.Role;

public class ReadRoleOut {
    private final Role role;

    public ReadRoleOut(Role role) {
        this.role = role;
    }
}
