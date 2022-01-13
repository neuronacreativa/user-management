package org.nc.usermanagement.application.usecases.role.delete;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.delete.dto.DeleteRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class DeleteRoleByUuidTest {

    @Autowired
    private DeleteRoleByUuid deleteRoleByUuid;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void valid() throws CreateRoleException, EntityException, ValueObjectException {

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER",
                        1000
                ), roleRepository
        );

        assertDoesNotThrow(() -> this.deleteRoleByUuid.delete(
                new DeleteRoleByUuidIn(
                        createRoleOut.getUuid()
                ),
                roleRepository
        ));
    }

    @Test
    void inValidRoleDoesNotExists() {
        assertThrows(RoleNotFoundException.class, () -> this.deleteRoleByUuid.delete(
                new DeleteRoleByUuidIn(
                        UUID.randomUUID().toString()
                ),
                roleRepository
        ));
    }
}