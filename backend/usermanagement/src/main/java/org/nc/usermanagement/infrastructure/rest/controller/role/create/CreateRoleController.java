package org.nc.usermanagement.infrastructure.rest.controller.role.create;

import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.rest.controller.role.create.dto.CreateRoleControllerIn;
import org.nc.usermanagement.infrastructure.rest.controller.role.create.dto.CreateRoleControllerOut;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

            CreateRoleOut createRoleOut = this.createRole.create(
                    new CreateRoleIn(
                            createRoleControllerIn.getRoleName(),
                            createRoleControllerIn.getPriority()
                    ), this.dbRoleRepository);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new CreateRoleControllerOut(
                            createRoleOut
                    )
            );

        } catch (CreateRoleException | EntityException | ValueObjectException e) {
            throw new UserManagementException(e);
        }

    }
}
