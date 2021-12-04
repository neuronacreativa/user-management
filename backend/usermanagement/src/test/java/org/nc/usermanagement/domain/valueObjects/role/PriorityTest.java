package org.nc.usermanagement.domain.valueObjects.role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriorityTest {

    @Test
    void valid() {
        Assertions.assertDoesNotThrow(() -> {
             new Priority(1);
        });
    }
}