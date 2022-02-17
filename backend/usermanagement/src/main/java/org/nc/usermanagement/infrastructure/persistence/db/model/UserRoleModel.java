package org.nc.usermanagement.infrastructure.persistence.db.model;

import javax.persistence.*;

@Entity
@Table(name = "UM_USER_ROLE")
public class UserRoleModel {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    RoleModel roleModel;

    public UserRoleModel() {
    }

    public UserRoleModel(int id, UserModel userModel, RoleModel roleModel) {
        this.id = id;
        this.userModel = userModel;
        this.roleModel = roleModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }
}
