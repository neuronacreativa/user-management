package org.nc.usermanagement.application.usecases.role.create.dto;

public class CreateRoleOut {
    private final String uuid;
    private final String roleName;
    private final int priority;

    public CreateRoleOut(CreateRoleIn createRoleIn) {
        this.uuid = createRoleIn.getRole().getUuid().getUuid();
        this.roleName = createRoleIn.getRole().getRoleName().getRoleName();
        this.priority = createRoleIn.getRole().getPriority().getPriority();
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
