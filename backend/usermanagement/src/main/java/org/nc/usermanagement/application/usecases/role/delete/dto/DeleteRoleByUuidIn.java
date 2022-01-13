package org.nc.usermanagement.application.usecases.role.delete.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class DeleteRoleByUuidIn {

    private final Uuid uuid;

    public DeleteRoleByUuidIn(String uuid) throws ValueObjectException {
        this.uuid = new Uuid(uuid);
    }

    public Uuid getUuid() {
        return uuid;
    }
}
