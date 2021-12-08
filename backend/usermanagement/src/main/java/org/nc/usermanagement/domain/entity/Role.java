package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.Entity;
import org.nc.usermanagement.domain.valueObjects.role.Priority;
import org.nc.usermanagement.domain.valueObjects.role.RoleName;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class Role implements Entity<Role> {

    private final Uuid uuid;
    private final RoleName roleName;
    private final Priority priority;

    public Role(String uuid, String roleName, int priority) throws ValueObjectException, EntityException {
        isValid(roleName);
        this.uuid = new Uuid(uuid);
        this.roleName = new RoleName(roleName);
        this.priority = new Priority(priority);
    }

    private void isValid(String roleName) throws EntityException {
        if (roleName == null || roleName.trim().length() == 0) {
            throw new EntityException("RoleName is mandatory");
        }
    }

    public Uuid getUuid() {
        return uuid;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public boolean sameIdentityAs(Role other) {
        return this.getUuid().equals(other.getUuid());
    }
}
