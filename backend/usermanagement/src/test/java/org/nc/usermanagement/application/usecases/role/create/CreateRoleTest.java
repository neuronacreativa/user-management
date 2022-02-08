package org.nc.usermanagement.application.usecases.role.create;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.FindRoleByUuid;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByUuidIn;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class CreateRoleTest {

    @Autowired
    private CreateRole createRole;

    @Autowired
    private FindRoleByUuid findRoleByUuid;

    @Autowired
    private DBRoleRepository DBRoleRepository;

    @Test
    void valid() {
        assertDoesNotThrow(() -> {
                CreateRoleOut createRoleOut = this.createRole.create(
                        new CreateRoleIn(
                                "ROLE_SUPER_ADMIN", 0
                        ), DBRoleRepository
                );
                findRoleByUuid.findRoleByUuid(
                        new FindRoleByUuidIn(createRoleOut.getUuid()),
                        DBRoleRepository
                );
            }
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