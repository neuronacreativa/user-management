package org.nc.usermanagement.domain.valueObjects.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.stream.Stream;

class UserNameTest {

    static Stream<String> validUserNameProvider() {
        return Stream.of(
                "validUserName",
                "user.name",
                "user-name",
                "user_name",
                "userName0",
                "userNaMe0123456789.-_"
        );
    }
    static Stream<String> invalidUserNameProvider() {
        return Stream.of(
                "ABC$$$$$$",
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with userName = {0}")
    @MethodSource("validUserNameProvider")
    void createValid(String userName) {
        Assertions.assertDoesNotThrow(() -> {
            new UserName(userName);
        });
    }

    @ParameterizedTest(name = "#{index} - Run test with userName = {0}")
    @MethodSource("invalidUserNameProvider")
    void createInValid(String userName) {
        Assertions.assertThrows(
                ValueObjectException.class, () ->
                        new UserName(userName));
    }

    @ParameterizedTest(name = "#{index} - Run test with userName = {0}")
    @MethodSource("validUserNameProvider")
    void readValid(String userNameString) throws ValueObjectException {
        UserName userName = new UserName(userNameString);
        Assertions.assertTrue(userName.sameValueAs(
                new UserName(userName.getUserName())
        ));
    }

}