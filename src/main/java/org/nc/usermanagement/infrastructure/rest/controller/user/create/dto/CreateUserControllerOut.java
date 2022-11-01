package org.nc.usermanagement.infrastructure.rest.controller.user.create.dto;

import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;

public class CreateUserControllerOut {

    private final String uuid;

    public CreateUserControllerOut(CreateUserOut createUserOut) {
        this.uuid = createUserOut.getUuid();
    }

    public String getUuid() {
        return uuid;
    }
}
