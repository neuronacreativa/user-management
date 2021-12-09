package org.nc.usermanagement.application.usecases.role.create;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.infrastructure.persistence.repository.MariaDBRoleRepository;

import static org.junit.jupiter.api.Assertions.*;

class CreateRoleTest {

    @Test
    void valid() {
        assertDoesNotThrow(() -> {
            CreateRole createRole = new CreateRole(
                    new MariaDBRoleRepository()
            );
            createRole.create(
                    new CreateRoleIn(
                            "SUPERADMIN", 0
                    )
            );
        });
    }
}