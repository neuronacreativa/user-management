package org.nc.usermanagement.infrastructure.persistence.model;

import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.role.Priority;
import org.nc.usermanagement.domain.valueObjects.role.RoleName;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;

import javax.persistence.*;

@Entity
@Table(name = "USR_ROLE")
public class RoleModel {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "UUID", unique = true, nullable = false, length = 40)
    private String uuid;

    @Column(name = "NAME", nullable = false, length = 20)
    private String roleName;

    @Column(name = "PRIORITY", nullable = false)
    private int priority;

    @ManyToOne
    @JoinColumn(name = "FK_ROLE_USER", nullable = false, updatable = false)
    private UserModel userModel;

    public RoleModel() {
    }

    public RoleModel(Role role) {
        this.uuid = role.getUuid().getUuid();
        this.roleName = role.getRoleName().getRoleName();
        this.priority = role.getPriority().getPriority();
    }

    public Role getRole() throws ValueObjectException, EntityException {
        return new Role(
                this.getUuid(),
                this.getRoleName(),
                this.getPriority()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
