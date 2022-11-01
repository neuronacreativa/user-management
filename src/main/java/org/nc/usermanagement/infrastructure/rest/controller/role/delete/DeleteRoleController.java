package org.nc.usermanagement.infrastructure.rest.controller.role.delete;

import org.nc.usermanagement.application.usecases.role.delete.DeleteRoleByUuid;
import org.nc.usermanagement.application.usecases.role.delete.dto.DeleteRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DeleteRoleController {

    @Autowired
    DeleteRoleByUuid deleteRoleByUuid;

    @Autowired
    DBRoleRepository dbRoleRepository;

    @DeleteMapping("role/{uuid}")
    public ResponseEntity<?> delete(
            @PathVariable String uuid
    ) throws UserManagementException {

        try {
            this.deleteRoleByUuid.delete(
                    new DeleteRoleByUuidIn(
                            uuid
                    ), dbRoleRepository
            );
        } catch (EntityException | RoleNotFoundException | ValueObjectException e) {
            throw new UserManagementException(e);
        }

        return ResponseEntity.ok().build();
    }
}
