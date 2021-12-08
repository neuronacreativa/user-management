package org.nc.usermanagement.domain.valueObjects.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import utils.TestingUtils;

class PasswordTest {

    private static final int CHAR_LIMIT = 20;

    @Test
    void valid() {
        Assertions.assertDoesNotThrow(() -> {
            new Password(TestingUtils.randomString(CHAR_LIMIT));
        });
    }

    @Test
    void inValidTooMuchChars() {
        Assertions.assertThrows(
                ValueObjectException.class, () ->
                        new Password(TestingUtils.randomString(CHAR_LIMIT + 1))
        );
    }
}