package org.nc.usermanagement.domain.valueObjects.role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.stream.Stream;

class RoleNameTest {

    static Stream<String> validRoleNameProvider() {
        return Stream.of(
                "SUPERADMIN",
                "SUPER-ADMIN",
                "SUPER.ADMIN",
                "SUPER_ADMIN",
                "SUPERADMIN0123456789"
        );
    }
    static Stream<String> invalidRoleNameProvider() {
        return Stream.of(
                "superadmin",
                "ABC$$$$$$",
                "abcdefghijklmnopqrstuvwxyz"
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with roleName = {0}")
    @MethodSource("validRoleNameProvider")
    void createValid(String roleName) {
        Assertions.assertDoesNotThrow(() -> {
            new RoleName(roleName);
        });
    }


    @ParameterizedTest(name = "#{index} - Run test with roleName = {0}")
    @MethodSource("invalidRoleNameProvider")
    void createInValid(String roleName) {
        Assertions.assertThrows(ValueObjectException.class,
                () -> new RoleName(roleName));
    }


    @ParameterizedTest(name = "#{index} - Run test with roleName = {0}")
    @MethodSource("validRoleNameProvider")
    void readValid(String roleNameString) {
        Assertions.assertDoesNotThrow(() -> {
            RoleName roleName = new RoleName(roleNameString);
            roleName.sameValueAs(new RoleName(roleName.getRoleName()));
        });
    }
}