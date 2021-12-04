package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.exception.DomainException;
import org.nc.usermanagement.domain.shared.Entity;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;
import org.nc.usermanagement.domain.valueObjects.user.Email;
import org.nc.usermanagement.domain.valueObjects.user.Password;
import org.nc.usermanagement.domain.valueObjects.user.UserName;

import java.util.List;

public class User implements Entity<User> {

    private final Uuid uuid;
    private final UserName userName;
    private final Password password;
    private final Email email;
    private final List<Role> roles;

    public User(String uuid, String userName, String password, String email, List<Role> roles) throws DomainException {
        this.uuid = new Uuid(uuid);
        this.userName = new UserName(userName);
        this.password = new Password(password);
        this.email = new Email(email);
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public boolean sameIdentityAs(User other) {
        return this.getUuid().equals(other.getUuid());
    }
}
