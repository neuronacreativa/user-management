package org.nc.usermanagement.application.usecases.user.create;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class CreateUserTest {

    @Autowired
    CreateUser createUser;

    @Autowired
    CreateRole createRole;

    @Autowired
    DBRoleRepository dbRoleRepository;

    @Autowired
    DBUserRepository dbUserRepository;

    @Test
    void valid() throws UseCaseException, EntityException, ValueObjectException {

        List<FindRoleByUuidIn> findRoleByUuidIns = new ArrayList<>();

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_SUPER_ADMIN", 0
                ), dbRoleRepository
        );

        findRoleByUuidIns.add(
                new FindRoleByUuidIn(
                        createRoleOut.getUuid()
                )
        );

        createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_USER", 1
                ), dbRoleRepository
        );

        findRoleByUuidIns.add(
                new FindRoleByUuidIn(
                        createRoleOut.getUuid()
                )
        );

        assertDoesNotThrow(() ->
                this.createUser.create(
                        new CreateUserIn(
                            "user.name",
                            "validPassword123!",
                            "user.name@example.org",
                                findRoleByUuidIns
                        ), dbUserRepository, dbRoleRepository
                )
        );
    }

    @Test
    void inValidRoleNotExists() throws CreateRoleException, ValueObjectException, EntityException {
        List<FindRoleByUuidIn> findRoleByUuidIns = new ArrayList<>();

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_SUPER_ADMIN", 0
                ), dbRoleRepository
        );

        findRoleByUuidIns.add(
                new FindRoleByUuidIn(
                        createRoleOut.getUuid()
                )
        );

        findRoleByUuidIns.add(
                new FindRoleByUuidIn(
                        UUID.randomUUID().toString()
                )
        );

        assertThrows(RoleNotFoundException.class, () ->
                this.createUser.create(
                        new CreateUserIn(
                                "user.name",
                                "validPassword123!",
                                "user.name@example.org",
                                findRoleByUuidIns
                        ), dbUserRepository, dbRoleRepository
                )
        );
    }

    // TODO: UserName has to be unique
}