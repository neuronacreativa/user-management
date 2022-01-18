package org.nc.usermanagement.infrastructure.rest.role.controller.read.dto;

import org.nc.usermanagement.application.usecases.role.read.dto.ReadByUuidIn;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindRoleByUuidControllerIn {

    private final ReadByUuidIn readByUuidIn;

    public FindRoleByUuidControllerIn(String uuid) throws ValueObjectException {
        this.readByUuidIn = new ReadByUuidIn(uuid);
    }

    public ReadByUuidIn getReadByUuidIn() {
        return readByUuidIn;
    }
}
