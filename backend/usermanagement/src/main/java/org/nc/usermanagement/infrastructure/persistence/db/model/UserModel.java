package org.nc.usermanagement.infrastructure.persistence.db.model;

import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UM_USER")
public class UserModel {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "UUID", unique = true, nullable = false, length = 40)
    private String uuid;

    @Column(name = "NAME", unique = true, nullable = false, length = 50)
    private String userName;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;

    // TODO: One role has many users

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "UM_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private List<RoleModel> roleModel;

    public UserModel() {
    }

    public UserModel(User user) {
        this.uuid = user.getUuid().getUuid();
        this.userName = user.getUserName().getUserName();
        this.password = user.getPassword().getPassword();
        this.email = user.getEmail().getEmail();
        this.roleModel = List.of(new RoleModel(user.getRole()));
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

    public List<RoleModel> getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(List<RoleModel> roleModel) {
        this.roleModel = roleModel;
    }

    public User getUser() throws EntityException, ValueObjectException {

        return new User(
                this.getUuid(),
                this.getUserName(),
                this.getPassword(),
                this.getEmail(),
                this.getRoleModel().get(0).getRole()
        );
    }
}
