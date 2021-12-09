package org.nc.usermanagement.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.EntityException;

import java.util.UUID;

class RoleTest {

    @Test
    void createValid(){
        Assertions.assertDoesNotThrow(() -> {
            new Role(
                    UUID.randomUUID().toString(),
                    "SUPERADMIN",
                    0
            );
        });
    }

    @Test
    void createInValid() {
        Assertions.assertThrows(EntityException.class, () -> {
                new Role(
                        UUID.randomUUID().toString(),
                        null,
                        0
                );
                new Role(
                        "This is not a Uuid",
                        "SUPERADMIN",
                        0
                );
                new Role(
                        UUID.randomUUID().toString(),
                        " ",
                        0
                );
        });
    }

    @Test
    void readValid() {
        Assertions.assertDoesNotThrow(() -> {
            Role role = new Role(
                    UUID.randomUUID().toString(),
                    "SUPERADMIN",
                    0
            );
            role.sameIdentityAs(
                    new Role(
                            role.getUuid().getUuid(),
                            role.getRoleName().getRoleName(),
                            role.getPriority().getPriority()
                    )
            );
        });
    }

}