package org.nc.usermanagement.infrastructure.rest.controller.role.update.dto;

public class UpdateRoleControllerIn {

    private final String roleName;
    private final int priority;

    public UpdateRoleControllerIn(String roleName, int priority) {
        this.roleName = roleName;
        this.priority = priority;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getPriority() {
        return priority;
    }
}
