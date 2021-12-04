package org.nc.usermanagement.domain.valueObjects.shared;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.ValueObject;

public class Uuid implements ValueObject<Uuid> {
    private final String uuid;
    private static final int CHAR_LIMIT = 50;

    public Uuid(String uuid) throws DomainException {
        isValid(uuid);
        this.uuid = uuid;
    }

    private void isValid(String uuid) throws DomainException {
        if (uuid.length() > CHAR_LIMIT) {
            throw new DomainException("This is a Domain Exception");
        }
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean sameValueAs(Uuid other) {
        return false;
    }
}
