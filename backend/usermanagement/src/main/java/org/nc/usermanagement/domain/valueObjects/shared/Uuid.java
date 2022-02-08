package org.nc.usermanagement.domain.valueObjects.shared;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.ValueObject;

import java.util.UUID;

public class Uuid implements ValueObject<Uuid> {
    private final String uuid;
    private static final int CHAR_LIMIT = 36;

    public Uuid(String uuid) throws ValueObjectException {
        isValid(uuid);
        this.uuid = uuid;
    }

    private void isValid(String uuid) throws ValueObjectException {
        if (uuid == null) {
            throw new ValueObjectException("userManagement.valueObject.ko.uuid.uuidRequired");
        }
        if (uuid.length() > CHAR_LIMIT) {
            throw new ValueObjectException("userManagement.valueObject.ko.uuid.charLimitExceeded");
        }
        try {
            UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new ValueObjectException("userManagement.valueObject.ko.uuid.invalidFormat");
        }
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean sameValueAs(Uuid other) {
        return this.getUuid().equals(other.getUuid());
    }
}
