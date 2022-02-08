package org.nc.usermanagement.domain.entity;

import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.domain.shared.Entity;
import org.nc.usermanagement.domain.valueObjects.shared.Uuid;
import org.nc.usermanagement.domain.valueObjects.user.Email;
import org.nc.usermanagement.domain.valueObjects.user.Password;
import org.nc.usermanagement.domain.valueObjects.user.UserName;

public class User implements Entity<User> {

    private final Uuid uuid;
    private final UserName userName;
    private final Password password;
    private final Email email;
    private final Role role;

    public User(String uuid, String userName, String password, String email, Role role) throws ValueObjectException, EntityException {
        isValid(userName, password, email, role);
        this.uuid = new Uuid(uuid);
        this.userName = new UserName(userName);
        this.password = new Password(password);
        this.email = new Email(email);
        this.role = role;
    }

    private void isValid(String userName, String password, String email, Role role) throws EntityException {
        if (userName == null || userName.trim().length() == 0) {
            throw new EntityException("userManagement.entity.ko.user.userNameRequired");
        }
        if (password == null || password.trim().length() == 0) {
            throw new EntityException("userManagement.entity.ko.user.passwordRequired");
        }
        if (email == null || email.trim().length() == 0) {
            throw new EntityException("userManagement.entity.ko.user.emailRequired");
        }
        if (role == null) {
            throw new EntityException("userManagement.entity.ko.user.roleRequired");
        }
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

    public Role getRole() {
        return role;
    }

    @Override
    public boolean sameIdentityAs(User other) {
        return this.getUuid().equals(other.getUuid());
    }
}
