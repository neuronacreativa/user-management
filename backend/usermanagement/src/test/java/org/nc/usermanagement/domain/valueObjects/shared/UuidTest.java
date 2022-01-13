package org.nc.usermanagement.domain.valueObjects.shared;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.UUID;
import java.util.stream.Stream;

class UuidTest {

    static Stream<String> validUuidProvider() {
        return Stream.of(
                UUID.randomUUID().toString()
        );
    }
    static Stream<String> invalidUuidProvider() {
        return Stream.of(
                "this is a bad uuid",
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
        );
    }


    @ParameterizedTest(name = "#{index} - Run test with Uuid = {0}")
    @MethodSource("validUuidProvider")
    void createValid(String Uuid) {
        Assertions.assertDoesNotThrow(() -> {
            new Uuid(Uuid);
        });
    }

    @ParameterizedTest(name = "#{index} - Run test with Uuid = {0}")
    @MethodSource("invalidUuidProvider")
    void createInValid(String Uuid) {
        Assertions.assertThrows(ValueObjectException.class,
                () -> new Uuid(Uuid)
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with Uuid = {0}")
    @MethodSource("validUuidProvider")
    void readValid(String Uuid) {
        Assertions.assertDoesNotThrow(() -> {
            Uuid uuid = new Uuid(Uuid);
            uuid.sameValueAs(new Uuid(uuid.getUuid()));
        });
    }
}