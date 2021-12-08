package org.nc.usermanagement.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.ArrayList;
import java.util.List;

class UserTest {

    private List<Role> getRoles() throws EntityException, ValueObjectException {
        List<Role> roleList = new ArrayList<>();
        Role role = new Role(
                "This is a Uuid",
                "This is a RoleName",
                0
        );
        roleList.add(role);
        return roleList;
    }

    private List<Role> getRolesEmpty() {
        return new ArrayList<>();
    }

    @Test
    void valid() {
        Assertions.assertDoesNotThrow(() -> {
            new User(
                    "This is a uuid",
                    "This is a UserName",
                    "This is a password",
                    "This is a email",
                    getRoles()
            );
        });
    }

    @Test
    void inValidUserName() {
        Assertions.assertThrows(EntityException.class, () -> {
            new User(
                    "This is a valid uuid",
                    null,
                    "This is a valid password",
                    "This is a valid email",
                    getRoles()
            );
            new User(
                    "This is a valid uuid",
                    " ",
                    "This is a valid password",
                    "This is a valid email",
                    getRoles()
            );
        });
    }

    @Test
    void inValidPassword() {
        Assertions.assertThrows(EntityException.class, () -> {
            new User(
                    "This is a valid uuid",
                    "This is a valid userName",
                    null,
                    "This is a valid email",
                    getRoles()
            );
            new User(
                    "This is a valid uuid",
                    "This is a valid userName",
                    " ",
                    "This is a valid email",
                    getRoles()
            );
        });
    }

    @Test
    void inValidEmail() {
        Assertions.assertThrows(EntityException.class, () -> {
            new User(
                    "This is a valid uuid",
                    "This is a valid userName",
                    "This is a valid password",
                    null,
                    getRoles()
            );
            new User(
                    "This is a valid uuid",
                    "This is a valid userName",
                    "This is a valid password",
                    " ",
                    getRoles()
            );
        });
    }

    @Test
    void inValidRole() {
        Assertions.assertThrows(EntityException.class, () ->
            new User(
                    "This is a uuid",
                    "This is a UserName",
                    "This is a password",
                    "This is a email",
                    getRolesEmpty()
            )
        );
    }
}