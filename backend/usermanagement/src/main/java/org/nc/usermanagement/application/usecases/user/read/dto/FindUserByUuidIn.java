package org.nc.usermanagement.application.usecases.user.read.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class FindUserByUuidIn {
    private final Uuid uuid;

    public FindUserByUuidIn(String uuid) throws ValueObjectException {
        this.uuid = new Uuid(uuid);
    }

    public Uuid getUuid() {
        return uuid;
    }
}
