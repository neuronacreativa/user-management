package org.nc.usermanagement.application.usecases.user.delete;


import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.user.create.CreateUser;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Transactional
class DeleteUserTest {

    @Autowired
    private DBUserRepository dbUserRepository;

    @Autowired
    CreateUser createUser;

    @Autowired
    private DeleteUser deleteUser;

    @Autowired
    CreateRole createRole;

    @Autowired
    DBRoleRepository dbRoleRepository;

    @Test
    void test()
            throws UseCaseException, EntityException, ValueObjectException
    {

        CreateRoleOut createRoleOut = this.createRole.create(
                new CreateRoleIn(
                        "ROLE_SUPER_ADMIN", 0
                ), dbRoleRepository
        );

        CreateUserOut createUserOut = this.createUser.create(
                new CreateUserIn(
                        "user.name",
                        "validPassword123!",
                        "user.name@example.org",
                        createRoleOut.getUuid()
                ), dbUserRepository, dbRoleRepository
        );

        assertDoesNotThrow(() ->
            this.deleteUser.delete(
                    new DeleteUserIn(
                            createUserOut.getUuid()
                    ), dbUserRepository
            )
        );

    }
}