package org.nc.usermanagement.application.usecases.role.read.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class FindRoleByUuidIn {

    private final Uuid uuid;

    public FindRoleByUuidIn(String uuid) throws ValueObjectException {
        this.uuid = new Uuid(uuid);
    }

    public Uuid getUuid() {
        return uuid;
    }
}
