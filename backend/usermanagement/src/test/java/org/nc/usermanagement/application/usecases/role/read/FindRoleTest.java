package org.nc.usermanagement.application.usecases.role.read;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleIn;
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
class FindRoleTest {

    @Autowired
    private FindRole findRole;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @Test
    void valid() throws CreateRoleException, EntityException, ValueObjectException {
        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER",
                        1000
                ),
                this.dbRoleRepository
        );

        assertDoesNotThrow(() -> {
            this.findRole.find(
                    new FindRoleIn(createRoleOut.getUuid(), createRoleOut.getRoleName()),
                    this.dbRoleRepository
            );
            this.findRole.find(
                    new FindRoleIn(null, createRoleOut.getRoleName()),
                    this.dbRoleRepository
            );
            this.findRole.find(
                    new FindRoleIn(createRoleOut.getUuid(), null),
                    this.dbRoleRepository
            );
        });
    }
}