package org.nc.usermanagement.domain.valueObjects.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import utils.TestingUtils;

class UserNameTest {

    private static final int CHAR_LIMIT = 50;

    @Test
    void valid() {
        Assertions.assertDoesNotThrow(() -> {
            new UserName(TestingUtils.randomString(CHAR_LIMIT));
        });
    }

    @Test
    void inValidTooMuchChars() {
        Assertions.assertThrows(
                ValueObjectException.class, () ->
                        new UserName(TestingUtils.randomString(CHAR_LIMIT + 1)));
    }

}