package org.nc.usermanagement.application.usecases.role.read.dto;

import org.nc.usermanagement.domain.entity.Role;

public class FindRoleOut {

    private final String uuid;
    private final String roleName;
    private final int priority;

    public FindRoleOut(Role role) {
        this.uuid = role.getUuid().getUuid();
        this.roleName = role.getRoleName().getRoleName();
        this.priority = role.getPriority().getPriority();
    }

    public String getUuid() {
        return uuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getPriority() {
        return priority;
    }
}
