package org.nc.usermanagement.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.nc.usermanagement.domain.exception.EntityException;

import java.util.UUID;
import java.util.stream.Stream;

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

    static Stream<String> invalidRoleNameProvider() {
        return Stream.of(
                " ",
                null
        );
    }

    static Stream<String> invalidUuidProvider() {
        return Stream.of(
                " ",
                null
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with roleName = {0}")
    @MethodSource("invalidRoleNameProvider")
    void createInValidRoleName(String roleName) {
        Assertions.assertThrows(EntityException.class, () ->
                new Role(
                        UUID.randomUUID().toString(),
                        roleName,
                        0
                )
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with uuid = {0}")
    @MethodSource("invalidUuidProvider")
    void createInValidUuid(String uuid) {
        Assertions.assertThrows(EntityException.class, () ->
                new Role(
                        uuid,
                        "SUPERADMIN",
                        0
                )
        );
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