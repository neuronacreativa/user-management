package org.nc.usermanagement.domain.valueObjects.role;

import org.nc.usermanagement.domain.shared.ValueObject;

public class Priority implements ValueObject<Priority> {

    private final int priority;

    public Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean sameValueAs(Priority other) {
        return this.getPriority() == other.getPriority();
    }
}
