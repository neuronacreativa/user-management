package org.nc.usermanagement.domain.valueObjects.role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.domain.exception.DomainException;

import java.util.Random;


class RoleNameTest {

    private static final int CHAR_LIMIT = 20;

    private String randomString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Test
    void valid() {
        Assertions.assertDoesNotThrow(() -> {
            new RoleName(this.randomString(CHAR_LIMIT));
        });
    }

    @Test
    void inValidTooMuchChars() {
        Assertions.assertThrows(DomainException.class,
                () -> new RoleName(this.randomString(CHAR_LIMIT + 1)));
    }


}