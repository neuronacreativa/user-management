package org.nc.usermanagement.infrastructure.rest.controller.role.create.dto;

import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;

public class CreateRoleControllerOut {

    private final String uuid;
    private final String roleName;
    private final int priority;

    public CreateRoleControllerOut(CreateRoleOut createRoleOut) {
        this.uuid = createRoleOut.getUuid();
        this.roleName = createRoleOut.getRoleName();
        this.priority = createRoleOut.getPriority();
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
