package org.nc.usermanagement.domain.valueObjects.shared;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.ValueObject;

public class Uuid implements ValueObject<Uuid> {
    private final String uuid;
    private static final int CHAR_LIMIT = 50;

    public Uuid(String uuid) throws ValueObjectException {
        isValid(uuid);
        this.uuid = uuid;
    }

    private void isValid(String uuid) throws ValueObjectException {
        if (uuid.length() > CHAR_LIMIT) {
            throw new ValueObjectException("This is a Domain Exception");
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
