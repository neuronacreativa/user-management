package org.nc.usermanagement.domain.valueObjects.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import utils.TestingUtils;

class UserNameTest {

    private static final int CHAR_LIMIT = 50;

    @Test
    void createValid() {
        Assertions.assertDoesNotThrow(() -> {
            new UserName(TestingUtils.randomString(CHAR_LIMIT));
        });
    }

    @Test
    void createInValidTooMuchChars() {
        Assertions.assertThrows(
                ValueObjectException.class, () ->
                        new UserName(TestingUtils.randomString(CHAR_LIMIT + 1)));
    }

    @Test
    void readValid() throws ValueObjectException {
        UserName userName = new UserName(TestingUtils.randomString(CHAR_LIMIT));
        Assertions.assertTrue(userName.sameValueAs(
                new UserName(userName.getUserName())
        ));
    }

}