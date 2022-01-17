package org.nc.usermanagement.application.usecases.role.update.dto;

public class UpdateRoleOut {
    private final String uuid;
    private final String roleName;
    private final int priority;

    public UpdateRoleOut(UpdateRoleIn updateRoleIn) {
        this.uuid = updateRoleIn.getRole().getUuid().getUuid();
        this.roleName = updateRoleIn.getRole().getRoleName().getRoleName();
        this.priority = updateRoleIn.getRole().getPriority().getPriority();
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
