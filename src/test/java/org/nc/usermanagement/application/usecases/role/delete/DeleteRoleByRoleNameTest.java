package org.nc.usermanagement.application.usecases.role.delete;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.delete.dto.DeleteRoleByRoleNameIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class DeleteRoleByRoleNameTest {

    @Autowired
    private DeleteRoleByRoleName deleteRoleByRoleName;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void valid() throws CreateRoleException, EntityException, ValueObjectException {

        this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER",
                        1000
                ), roleRepository
        );

        assertDoesNotThrow(() -> this.deleteRoleByRoleName.delete(
                new DeleteRoleByRoleNameIn(
                        "ROLE_USER"
                ),
                roleRepository
        ));
    }

    @Test
    void inValidRoleDoesNotExists() throws CreateRoleException, EntityException, ValueObjectException {

        this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER",
                        1000
                ), roleRepository
        );

        assertThrows(RoleNotFoundException.class, () -> this.deleteRoleByRoleName.delete(
                new DeleteRoleByRoleNameIn(
                        "ROLE_NOT_USER"
                ),
                roleRepository
        ));
    }
}