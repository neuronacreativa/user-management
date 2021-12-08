package org.nc.usermanagement.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.EntityException;

class RoleTest {

    @Test
    void valid(){
        Assertions.assertDoesNotThrow(() -> {
            new Role(
                    "This is a new uuid",
                    "This is a RoleName",
                    0
            );
        });
    }

    @Test
    void inValidRoleName() {
        Assertions.assertThrows(EntityException.class, () ->
            new Role(
                    "This is a new uuid",
                    null,
                    0
            )
        );

        Assertions.assertThrows(EntityException.class, () ->
            new Role(
                    "This is a new uuid",
                    " ",
                    0
            )
        );
    }

}