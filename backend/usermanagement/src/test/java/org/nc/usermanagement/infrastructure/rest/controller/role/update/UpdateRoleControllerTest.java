package org.nc.usermanagement.infrastructure.rest.controller.role.update;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.rest.controller.role.update.dto.UpdateRoleControllerIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class UpdateRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository roleRepository;

    @Test
    void valid() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateRoleIn createRoleIn = new CreateRoleIn(
                "ROLE_SUPER_ADMIN",
                0
        );

        CreateRoleOut createRoleOut = this.createRole.create(
                createRoleIn, roleRepository
        );

        String requestJson = objectMapper.writeValueAsString(
                new UpdateRoleControllerIn(
                        createRoleOut.getRoleName(),
                        createRoleOut.getPriority()
                )
        );

        this.mockMvc.perform(
                        put("/role/" + createRoleOut.getUuid())
                                .content(requestJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}