package org.nc.usermanagement.infrastructure.rest.controller.role.delete;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
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
class DeleteRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository roleRepository;

    @Test
    void valid() throws Exception {

        CreateRoleIn createRoleIn = new CreateRoleIn(
                "ROLE_SUPER_ADMIN",
                0
        );

        CreateRoleOut createRoleOut = this.createRole.create(
                createRoleIn, roleRepository
        );

        this.mockMvc.perform(
                        delete("/api/role/" + createRoleOut.getUuid())
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

}
