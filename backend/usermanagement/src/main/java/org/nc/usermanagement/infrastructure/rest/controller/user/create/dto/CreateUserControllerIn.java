package org.nc.usermanagement.infrastructure.rest.controller.user.create.dto;

import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class CreateUserControllerIn {

    private final String userName;
    private final String password;
    private final String email;
    private final String roleUuid;

    public CreateUserControllerIn(String userName, String password, String email, String roleUuid) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleUuid = roleUuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public CreateUserIn getCreateUserIn() throws ValueObjectException {
        return new CreateUserIn(
                this.getUserName(),
                this.getPassword(),
                this.getEmail(),
                this.getRoleUuid()
        );
    }
}
