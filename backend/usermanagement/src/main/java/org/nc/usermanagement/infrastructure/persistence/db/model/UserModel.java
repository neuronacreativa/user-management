package org.nc.usermanagement.infrastructure.persistence.db.model;

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


    @OneToMany(mappedBy = "userModel")
    List<UserRoleModel> userRoleModels;

    public UserModel() {
    }

    public UserModel(int id, String uuid, String userName, String password, String email, List<UserRoleModel> userRoleModels) {
        this.id = id;
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRoleModels = userRoleModels;
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

    public List<UserRoleModel> getUserRoleModels() {
        return userRoleModels;
    }

    public void setUserRoleModels(List<UserRoleModel> userRoleModels) {
        this.userRoleModels = userRoleModels;
    }
}
