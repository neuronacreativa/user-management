package org.nc.usermanagement.infrastructure.rest.role.controller;

import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.nc.usermanagement.infrastructure.rest.role.controller.dto.CreateRoleControllerIn;
import org.nc.usermanagement.infrastructure.rest.role.controller.dto.CreateRoleControllerOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class CreateRoleController {

    @Autowired
    private CreateRole createRole;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @PostMapping("role")
    public ResponseEntity<CreateRoleControllerOut> create(
            @RequestBody CreateRoleControllerIn createRoleControllerIn
    ) throws UserManagementException {

        try {

            CreateRoleIn createRoleIn = new CreateRoleIn(
                    createRoleControllerIn.getRoleName(),
                    createRoleControllerIn.getPriority()
            );

            CreateRoleOut createRoleOut = this.createRole.create(createRoleIn, this.dbRoleRepository);
            return ResponseEntity.created(
                    new URI(createRoleOut.getUuid())
            ).build();

        } catch (CreateRoleException | EntityException | ValueObjectException | URISyntaxException e) {
            throw new UserManagementException(e);
        }

    }
}
