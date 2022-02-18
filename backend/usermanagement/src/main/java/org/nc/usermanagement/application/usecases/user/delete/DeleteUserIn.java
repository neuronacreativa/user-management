package org.nc.usermanagement.application.usecases.user.delete;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class DeleteUserIn {

    private final Uuid uuid;

    public DeleteUserIn(String uuid) throws ValueObjectException {
        this.uuid = new Uuid(uuid);
    }

    public Uuid getUuid() {
        return this.uuid;
    }
}
