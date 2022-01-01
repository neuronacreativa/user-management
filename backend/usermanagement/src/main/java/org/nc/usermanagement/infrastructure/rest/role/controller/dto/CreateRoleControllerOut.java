package org.nc.usermanagement.infrastructure.rest.role.controller.dto;

public class CreateRoleControllerOut {

    private final String uuid;
    private final String roleName;
    private final int priority;

    public CreateRoleControllerOut(String uuid, String roleName, int priority) {
        this.uuid = uuid;
        this.roleName = roleName;
        this.priority = priority;
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
