package org.nc.usermanagement.application.usecases.role.read.dto;

public class FindRoleOut {

    private final String uuid;
    private final String roleName;
    private final int priority;

    public FindRoleOut(String uuid, String roleName, int priority) {
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
