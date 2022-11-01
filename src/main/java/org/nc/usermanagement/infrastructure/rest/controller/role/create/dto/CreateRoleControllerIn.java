package org.nc.usermanagement.infrastructure.rest.controller.role.create.dto;

public class CreateRoleControllerIn {

    private final String roleName;
    private final int priority;

    public CreateRoleControllerIn(String roleName, int priority) {
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
