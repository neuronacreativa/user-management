package org.nc.usermanagement.infrastructure.rest.role.controller.read.dto;

import org.nc.usermanagement.application.usecases.role.read.dto.ReadRoleOut;

public class FindRoleControllerOut {

    private final String uuid;
    private final String roleName;
    private final int priority;

    public FindRoleControllerOut(ReadRoleOut readRoleOut) {
        this.uuid = readRoleOut.getUuid();
        this.roleName = readRoleOut.getRoleName();
        this.priority = readRoleOut.getPriority();
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
