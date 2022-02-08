package org.nc.usermanagement.infrastructure.rest.controller.user.create.dto;

import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class CreateUserControllerIn {

    private final CreateUserIn createUserIn;

    public CreateUserControllerIn(String userName, String password, String email, String uuid)
            throws ValueObjectException
    {
        this.createUserIn = new CreateUserIn(
                userName, password, email, uuid
        );
    }

    public CreateUserIn getCreateUserIn() {
        return createUserIn;
    }
}
