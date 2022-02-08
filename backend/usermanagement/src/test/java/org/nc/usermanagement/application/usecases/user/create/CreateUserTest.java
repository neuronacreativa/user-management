package org.nc.usermanagement.application.usecases.user.create;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;
import org.nc.usermanagement.application.usecases.user.read.FindUserByUuid;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserByUuidIn;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class CreateUserTest {

    @Autowired
    CreateUser createUser;

    @Autowired
    FindUserByUuid findUserByUuid;

    @Autowired
    CreateRole createRole;

    @Autowired
    DBRoleRepository dbRoleRepository;

    @Autowired
    DBUserRepository dbUserRepository;

    @Test
    void valid() throws UseCaseException, EntityException, ValueObjectException {

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_SUPER_ADMIN", 0
                ), dbRoleRepository
        );

        assertDoesNotThrow(() -> {
                CreateUserOut createUserOut = this.createUser.create(
                        new CreateUserIn(
                                "user.name",
                                "validPassword123!",
                                "user.name@example.org",
                                createRoleOut.getUuid()
                        ), dbUserRepository, dbRoleRepository
                );
                findUserByUuid.findUserByUuid(
                        new FindUserByUuidIn(createUserOut.getUuid()),
                        dbUserRepository
                );
            }
        );
    }

    @Test
    void inValidRoleNotExists() {

        assertThrows(RoleNotFoundException.class, () ->
                this.createUser.create(
                        new CreateUserIn(
                                "user.name",
                                "validPassword123!",
                                "user.name@example.org",
                                UUID.randomUUID().toString()
                        ), dbUserRepository, dbRoleRepository
                )
        );
    }
}