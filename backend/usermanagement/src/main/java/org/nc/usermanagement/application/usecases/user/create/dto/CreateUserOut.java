package org.nc.usermanagement.application.usecases.user.create.dto;

public class CreateUserOut {
    private final String uuid;

    public CreateUserOut(CreateUserIn createUserIn) {
        this.uuid = createUserIn.getUuid().getUuid();
    }

    public String getUuid() {
        return uuid;
    }
}
