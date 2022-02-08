package org.nc.usermanagement.application.usecases.user.read.dto;

import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleOut;
import org.nc.usermanagement.domain.entity.User;

public class FindUserOut {
    private final String uuid;
    private final String userName;
    private final String password;
    private final String email;
    private final FindRoleOut role;

    public FindUserOut(User user) {
        this.uuid = user.getUuid().getUuid();
        this.userName = user.getUserName().getUserName();
        this.password = user.getPassword().getPassword();
        this.email = user.getEmail().getEmail();
        this.role = new FindRoleOut(user.getRole());
    }

    public String getUuid() {
        return uuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public FindRoleOut getRole() {
        return role;
    }
}
