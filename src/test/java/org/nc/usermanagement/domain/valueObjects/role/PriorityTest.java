package org.nc.usermanagement.domain.valueObjects.role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriorityTest {

    @Test
    void createValid() {
        Assertions.assertDoesNotThrow(() -> {
             new Priority(1);
        });
    }

    @Test
    void readValid() {
        Assertions.assertDoesNotThrow(() -> {
            Priority priority = new Priority(1);
            priority.sameValueAs(new Priority(priority.getPriority()));
        });
    }
}