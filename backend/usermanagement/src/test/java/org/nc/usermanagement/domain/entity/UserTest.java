package org.nc.usermanagement.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.UUID;

class UserTest {

    private Role getRole() throws EntityException, ValueObjectException {
        return new Role(
                UUID.randomUUID().toString(),
                "ROLE_SUPER_ADMIN",
                0
        );
    }

    @Test
    void createValid() {
        Assertions.assertDoesNotThrow(() -> {
            new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    "A~$^+=<>a1",
                    "user.example@test.org",
                    getRole()
            );
        });
    }

    @Test
    void createInValidUserName() {
        Assertions.assertThrows(EntityException.class, () -> {
            new User(
                    UUID.randomUUID().toString(),
                    null,
                    "A~$^+=<>a1",
                    "user.example@test.org",
                    getRole()
            );
            new User(
                    UUID.randomUUID().toString(),
                    " ",
                    "A~$^+=<>a1",
                    "user.example@test.org",
                    getRole()
            );
        });
    }

    @Test
    void createInValidPassword() {
        Assertions.assertThrows(EntityException.class, () -> {
            new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    null,
                    "user.example@test.org",
                    getRole()
            );
            new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    " ",
                    "user.example@test.org",
                    getRole()
            );
        });
    }

    @Test
    void createInValidEmail() {
        Assertions.assertThrows(EntityException.class, () -> {
            new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    "A~$^+=<>a1",
                    null,
                    getRole()
            );
            new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    "A~$^+=<>a1",
                    " ",
                    getRole()
            );
        });
    }

    @Test
    void createInValidRole() {
        Assertions.assertThrows(EntityException.class, () ->
            new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    "A~$^+=<>a1",
                    "user.example@test.org",
                    null
            )
        );
    }

    @Test
    void readValid() {
        Assertions.assertDoesNotThrow(() -> {
            User user= new User(
                    UUID.randomUUID().toString(),
                    "user.test",
                    "A~$^+=<>a1",
                    "user.example@test.org",
                    getRole()
            );
            user.sameIdentityAs(
                    new User(
                            user.getUuid().getUuid(),
                            user.getUserName().getUserName(),
                            user.getPassword().getPassword(),
                            user.getEmail().getEmail(),
                            user.getRole()
                    )
            );
        });
    }}