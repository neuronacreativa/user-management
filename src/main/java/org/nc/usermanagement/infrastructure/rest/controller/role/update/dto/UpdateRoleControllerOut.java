package org.nc.usermanagement.infrastructure.rest.controller.role.update.dto;

import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleOut;

public class UpdateRoleControllerOut {

    private final String uuid;
    private final String roleName;
    private final int priority;

    public UpdateRoleControllerOut(UpdateRoleOut updateRoleOut) {
        this.uuid = updateRoleOut.getUuid();
        this.roleName = updateRoleOut.getRoleName();
        this.priority = updateRoleOut.getPriority();
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
