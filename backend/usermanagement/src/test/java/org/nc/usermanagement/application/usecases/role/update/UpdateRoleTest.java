package org.nc.usermanagement.application.usecases.role.update;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleIn;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;
import java.util.UUID;

@SpringBootTest
@Transactional
class UpdateRoleTest {

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @Autowired
    private UpdateRole updateRole;

    @Autowired
    private CreateRole createRole;

    @Test
    void valid() throws CreateRoleException, EntityException, ValueObjectException {

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn("ROLE_USER", 1000),
                dbRoleRepository
        );

        assertDoesNotThrow(() ->
            this.updateRole.update(
                    new UpdateRoleIn(
                            createRoleOut.getUuid(),
                            createRoleOut.getRoleName(),
                            createRoleOut.getPriority()
                    ), dbRoleRepository
            )
        );
    }

    @Test
    void inValidRoleDoesNotExists() {
        assertThrows(RoleNotFoundException.class, () -> this.updateRole.update(
                new UpdateRoleIn(
                        UUID.randomUUID().toString(),
                        "ROLE_NOT_FOUND",
                        1000
                ),
                dbRoleRepository
        ));
    }

}