package org.nc.usermanagement.application.usecases.role.read;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.dto.ReadByRoleNameIn;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class ReadRoleTest {

    @Autowired
    private ReadRole readRole;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    // TODO
    @Test
    void validReadRoleByRoleName() throws CreateRoleException, EntityException, ValueObjectException {

        this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER",
                        1000
                ),
                this.dbRoleRepository
        );

        assertDoesNotThrow(() ->
                this.readRole.readByRoleName(
                        new ReadByRoleNameIn("ROLE_USER"),
                        this.dbRoleRepository
                )
        );

    }
}