package org.nc.usermanagement.application.usecases.user.update.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class UpdateUserIn {

    private final Uuid uuid;

    public UpdateUserIn(String uuid) throws ValueObjectException {
        this.uuid = new Uuid(uuid);
    }

    public Uuid getUuid() {
        return uuid;
    }
}
