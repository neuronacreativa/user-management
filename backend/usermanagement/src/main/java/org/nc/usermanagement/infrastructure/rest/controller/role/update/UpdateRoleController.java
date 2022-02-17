package org.nc.usermanagement.infrastructure.rest.controller.role.update;

import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.role.update.UpdateRole;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleIn;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleOut;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.rest.controller.role.update.dto.UpdateRoleControllerIn;
import org.nc.usermanagement.infrastructure.rest.controller.role.update.dto.UpdateRoleControllerOut;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateRoleController {

    @Autowired
    private UpdateRole updateRole;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @PutMapping("role/{uuid}")
    public ResponseEntity<UpdateRoleControllerOut> update(
            @PathVariable String uuid,
            @RequestBody UpdateRoleControllerIn updateRoleControllerIn
    ) throws UserManagementException {

        try {
            UpdateRoleOut updateRoleOut = updateRole.update(
                    new UpdateRoleIn(
                            uuid,
                            updateRoleControllerIn.getRoleName(),
                            updateRoleControllerIn.getPriority()
                    ), dbRoleRepository
            );

            return ResponseEntity.status(HttpStatus.OK).body(
                    new UpdateRoleControllerOut(
                            updateRoleOut
                    )
            );
        } catch (RoleNotFoundException | ValueObjectException | EntityException e) {
            throw new UserManagementException(e);
        }

    }
}
