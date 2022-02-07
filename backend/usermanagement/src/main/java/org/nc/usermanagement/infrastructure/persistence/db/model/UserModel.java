package org.nc.usermanagement.infrastructure.persistence.db.model;

import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserModel {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "UUID", unique = true, nullable = false, length = 40)
    private String uuid;

    @Column(name = "NAME", nullable = false, length = 50)
    private String userName;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    // TODO: One role has many users

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userModel")
    private List<RoleModel> roleModels;

    public UserModel() {
    }

    public UserModel(User user) {
        this.uuid = user.getUuid().getUuid();
        this.userName = user.getUserName().getUserName();
        this.password = user.getPassword().getPassword();
        this.email = user.getEmail().getEmail();

        List<RoleModel> roleModelList = new ArrayList<>();
        user.getRoles().forEach((r) ->
            roleModelList.add(
                    new RoleModel(r)
            )
        );
        this.roleModels = roleModelList;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }

    public User getUser() throws EntityException, ValueObjectException {

        List<Role> roles = new ArrayList<>();

        for (RoleModel roleModel : this.getRoleModels()) {
            roles.add(roleModel.getRole());
        }

        return new User(
                this.getUuid(),
                this.getUserName(),
                this.getPassword(),
                this.getEmail(),
                roles
        );
    }
}
