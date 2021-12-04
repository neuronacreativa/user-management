package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.Entity;
import org.nc.usermanagement.domain.valueObjects.role.Priority;
import org.nc.usermanagement.domain.valueObjects.role.RoleName;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

public class Role implements Entity<Role> {

    private final Uuid uuid;
    private final RoleName roleName;
    private final Priority priority;

    public Role(String uuid, String roleName, int priority) throws DomainException {
        this.uuid = new Uuid(uuid);
        this.roleName = new RoleName(roleName);
        this.priority = new Priority(priority);
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
