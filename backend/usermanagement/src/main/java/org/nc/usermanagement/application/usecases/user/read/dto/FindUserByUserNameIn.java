package org.nc.usermanagement.application.usecases.user.read.dto;

import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.user.UserName;

public class FindUserByUserNameIn {

    private final UserName userName;

    public FindUserByUserNameIn(String userName) throws ValueObjectException {
        this.userName = new UserName(userName);
    }

    public UserName getUserName() {
        return userName;
    }
}
