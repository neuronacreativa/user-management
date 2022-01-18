package org.nc.usermanagement.infrastructure.rest.role.controller.read;

import org.nc.usermanagement.application.usecases.role.read.FindRoleByRoleName;
import org.nc.usermanagement.application.usecases.role.read.FindRoleByUuid;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.nc.usermanagement.infrastructure.rest.role.controller.read.dto.FindRoleByRoleNameControllerIn;
import org.nc.usermanagement.infrastructure.rest.role.controller.read.dto.FindRoleByUuidControllerIn;
import org.nc.usermanagement.infrastructure.rest.role.controller.read.dto.FindRoleControllerOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadRoleController {

    @Autowired
    FindRoleByUuid findRoleByUuid;

    @Autowired
    FindRoleByRoleName findRoleByRoleName;

    @Autowired
    DBRoleRepository dbRoleRepository;

    @GetMapping("role/find/")
    public ResponseEntity<FindRoleControllerOut> findRoleByRoleName(
            @RequestParam("roleName") FindRoleByRoleNameControllerIn findRoleByRoleNameControllerIn
            //@RequestParam("uuid") FindRoleByUuidControllerIn findRoleByUuidControllerIn
    ) throws UserManagementException {

        try{
            return ResponseEntity.ok(
                    new FindRoleControllerOut(
                            this.findRoleByRoleName.findByRoleName(
                                    findRoleByRoleNameControllerIn.getReadByRoleNameIn(),
                                    dbRoleRepository
                            )
                    )
            );
        } catch (EntityException | RoleNotFoundException | ValueObjectException e) {
            throw new UserManagementException(e);
        }
    }

}
