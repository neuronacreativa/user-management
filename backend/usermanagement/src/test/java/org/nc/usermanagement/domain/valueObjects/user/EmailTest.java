package org.nc.usermanagement.domain.valueObjects.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import utils.TestingUtils;

class EmailTest {

    private static final int CHAR_LIMIT = 100;

    @Test
    void valid() {
        Assertions.assertDoesNotThrow(() -> {
            new Email(TestingUtils.randomString(CHAR_LIMIT));
        });
    }

    @Test
    void inValidTooMuchChars() {
        Assertions.assertThrows(
                ValueObjectException.class, () ->
                        new Email(TestingUtils.randomString(CHAR_LIMIT + 1))
        );
    }
}