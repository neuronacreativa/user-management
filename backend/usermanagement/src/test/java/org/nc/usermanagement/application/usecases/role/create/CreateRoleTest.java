package org.nc.usermanagement.application.usecases.role.create;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.infrastructure.persistence.mariadb.repository.MariaDBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateRoleTest {

    @Autowired
    private MariaDBRoleRepository mariaDBRoleRepository;

    @Test
    void valid() {
        assertDoesNotThrow(() -> {
            CreateRole createRole = new CreateRole(
                    mariaDBRoleRepository
            );
            createRole.create(
                    new CreateRoleIn(
                            "SUPERADMIN", 0
                    )
            );
        });
    }
}