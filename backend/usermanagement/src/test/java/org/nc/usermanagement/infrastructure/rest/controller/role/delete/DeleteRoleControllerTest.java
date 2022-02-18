package org.nc.usermanagement.infrastructure.rest.controller.role.delete;

import org.junit.jupiter.api.Test;
import org.nc.usermanagement.application.usecases.role.delete.DeleteRoleByUuid;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class DeleteRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeleteRoleByUuid deleteRoleByUuid;

    @Autowired
    private DBRoleRepository roleRepository;

    @Test
    void valid() {

    }
}