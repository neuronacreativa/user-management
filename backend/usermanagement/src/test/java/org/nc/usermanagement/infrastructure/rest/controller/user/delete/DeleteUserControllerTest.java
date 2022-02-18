package org.nc.usermanagement.infrastructure.rest.controller.user.delete;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.user.create.CreateUser;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class DeleteUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreateUser createUser;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBUserRepository dbUserRepository;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @Test
    void valid()
            throws Exception {
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

        this.mockMvc.perform(
                        delete("/user/" + createUserOut.getUuid())
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}