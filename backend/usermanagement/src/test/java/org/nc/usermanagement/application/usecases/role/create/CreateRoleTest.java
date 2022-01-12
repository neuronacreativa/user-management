package org.nc.usermanagement.application.usecases.role.create;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CreateRoleTest {

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository DBRoleRepository;

    @Test
    void valid() {
        assertDoesNotThrow(() ->
                this.createRole.create(
                        new CreateRoleIn(
                                "ROLE_SUPER_ADMIN", 0
                        ), DBRoleRepository
                )
        );
    }

    @Test
    void inValidRoleNameAlreadyExists() {
        assertThrows(CreateRoleException.class, () -> {
                this.createRole.create(
                        new CreateRoleIn(
                                "ROLE_SUPER_ADMIN", 0
                        ), DBRoleRepository
                );
                this.createRole.create(
                        new CreateRoleIn(
                                "ROLE_SUPER_ADMIN", 0
                        ), DBRoleRepository
                );
            }
        );
    }

    @Test
    void inValidRoleName() {
        assertThrows(CreateRoleException.class, () ->
                this.createRole.create(
                        new CreateRoleIn(
                                "Invalid", 0
                        ), DBRoleRepository
                )
        );
    }
}