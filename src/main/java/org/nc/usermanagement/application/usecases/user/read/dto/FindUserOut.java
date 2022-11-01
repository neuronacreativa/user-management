package org.nc.usermanagement.application.usecases.user.read.dto;

import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleOut;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class FindUserOut {
    private final String uuid;
    private final String userName;
    private final String password;
    private final String email;
    private final List<FindRoleOut> findRoleOuts;

    public FindUserOut(User user) {
        this.uuid = user.getUuid().getUuid();
        this.userName = user.getUserName().getUserName();
        this.password = user.getPassword().getPassword();
        this.email = user.getEmail().getEmail();
        this.findRoleOuts = new ArrayList<>();

        for (Role role : user.getRoles()) {
            this.findRoleOuts.add(new FindRoleOut(role));
        }
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

    public List<FindRoleOut> getFindRoleOuts() {
        return findRoleOuts;
    }
}
