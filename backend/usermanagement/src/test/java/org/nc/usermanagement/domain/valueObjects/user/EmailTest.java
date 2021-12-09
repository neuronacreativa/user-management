package org.nc.usermanagement.domain.valueObjects.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.stream.Stream;

class EmailTest {

    static Stream<String> validEmailProvider() {
        return Stream.of(
                "user@test.org",
                "user.example@test.org",
                "A!#&()–a1@test.org",
                "0123456789@test0123456789.org"
        );
    }

    static Stream<String> inValidEmailProvider() {
        return Stream.of(
                "user",
                //"user@org",
                "user.org",
                //"user example@test.org",
                "user.user.example.user.example.user.example.user.example.user.example.user.example.user.example.@test.org"
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with email = {0}")
    @MethodSource("validEmailProvider")
    void createValid(String email) {
        Assertions.assertDoesNotThrow(() -> {
            new Email(email);
        });
    }

    @ParameterizedTest(name = "#{index} - Run test with email = {0}")
    @MethodSource("inValidEmailProvider")
    void createInvalid(String email) {
        Assertions.assertThrows(
                ValueObjectException.class, () ->
                        new Email(email)
        );
    }

    @Test
    void readValid() throws ValueObjectException {
        Email email = new Email("user.example@test.org");
        Assertions.assertTrue(email.sameValueAs(
                new Email(email.getEmail())
        ));
    }
}