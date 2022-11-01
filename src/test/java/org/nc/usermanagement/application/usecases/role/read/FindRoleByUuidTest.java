package org.nc.usermanagement.application.usecases.role.read;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class FindRoleByUuidTest {

    @Autowired
    private FindRoleByUuid findRoleByUuid;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @Test
    void validReadRoleByRoleName() throws CreateRoleException, EntityException, ValueObjectException {

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER",
                        1000
                ),
                this.dbRoleRepository
        );

        assertDoesNotThrow(() ->
                this.findRoleByUuid.findRoleByUuid(
                        new FindRoleByUuidIn(createRoleOut.getUuid()),
                        this.dbRoleRepository
                )
        );
    }

    @Test
    void inValidRoleDoesNotExists() {
        assertThrows(RoleNotFoundException.class, () ->
                this.findRoleByUuid.findRoleByUuid(
                        new FindRoleByUuidIn(UUID.randomUUID().toString()),
                        this.dbRoleRepository
                )
        );
    }
}