package org.nc.usermanagement.infrastructure.rest.controller.role.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.nc.usermanagement.infrastructure.rest.controller.role.create.dto.CreateRoleControllerIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CreateRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void valid() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        CreateRoleControllerIn createRoleControllerIn = new CreateRoleControllerIn(
                "ROLE_SUPER_ADMIN",
                0
        );

        String requestJson = objectMapper.writeValueAsString(createRoleControllerIn);

        this.mockMvc.perform(
                post("/api/role")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // TODO: Add tests for 4XX response

}