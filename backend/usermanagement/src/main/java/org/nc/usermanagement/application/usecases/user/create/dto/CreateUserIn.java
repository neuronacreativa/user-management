package org.nc.usermanagement.application.usecases.user.create.dto;

import org.nc.usermanagement.application.usecases.role.read.dto.ReadByUuidIn;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;
import org.nc.usermanagement.domain.valueObjects.user.Email;
import org.nc.usermanagement.domain.valueObjects.user.Password;
import org.nc.usermanagement.domain.valueObjects.user.UserName;

import java.util.List;
import java.util.UUID;

public class CreateUserIn {

    private final Uuid uuid;
    private final UserName userName;
    private final Password password;
    private final Email email;
    private final List<ReadByUuidIn> readByUuidIns;

    public CreateUserIn(String userName, String password, String email, List<ReadByUuidIn> readByUuidIns) throws ValueObjectException {
        this.uuid = new Uuid(UUID.randomUUID().toString());
        this.userName = new UserName(userName);
        this.password = new Password(password);
        this.email = new Email(email);
        this.readByUuidIns = readByUuidIns;
    }

    public Uuid getUuid() {
        return uuid;
    }

    public UserName getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }

    public List<ReadByUuidIn> getReadByUuidIns() {
        return readByUuidIns;
    }
}
