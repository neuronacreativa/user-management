package org.nc.usermanagement.infrastructure.rest.role.controller;

import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.create.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CreateRoleController {

    private final CreateRole createRole;
    private final DBRoleRepository dbRoleRepository;

    public CreateRoleController(CreateRole createRole, DBRoleRepository dbRoleRepository) {
        this.createRole = createRole;
        this.dbRoleRepository = dbRoleRepository;
    }

    @PostMapping("role")
    public ResponseEntity<?> create(
            @RequestBody CreateRoleIn createRoleIn
    ) {
        try {
            this.createRole.create(createRoleIn, this.dbRoleRepository);
            return ResponseEntity.ok().build();
        } catch (CreateRoleException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Foo Not Found", e
            );
        }
    }
}
