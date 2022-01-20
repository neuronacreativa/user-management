package org.nc.usermanagement.application.usecases.role.read.dto;

public class FindRoleIn {

    private final String uuid;
    private final String roleName;

    public FindRoleIn(String uuid, String roleName) {
        this.uuid = uuid;
        this.roleName = roleName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getRoleName() {
        return roleName;
    }
}
