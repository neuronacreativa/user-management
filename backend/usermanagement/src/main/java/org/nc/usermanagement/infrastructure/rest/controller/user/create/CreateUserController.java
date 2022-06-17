package org.nc.usermanagement.infrastructure.rest.controller.user.create;

import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.user.create.CreateUser;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBUserRepository;
import org.nc.usermanagement.infrastructure.rest.controller.user.create.dto.CreateUserControllerIn;
import org.nc.usermanagement.infrastructure.rest.controller.user.create.dto.CreateUserControllerOut;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CreateUserController {

    @Autowired
    private CreateUser createUser;

    @Autowired
    private DBUserRepository dbUserRepository;

    @Autowired
    private DBRoleRepository dbRoleRepository;

    @PostMapping("user")
    public ResponseEntity<CreateUserControllerOut> create(
            @RequestBody CreateUserControllerIn createUserControllerIn
    ) throws UserManagementException {

        try {

            CreateUserOut createUserOut = this.createUser.create(
                    createUserControllerIn.getCreateUserIn(),
                    dbUserRepository, dbRoleRepository
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new CreateUserControllerOut(
                            createUserOut
                    )
            );

        } catch (EntityException | ValueObjectException | UseCaseException e) {
            throw new UserManagementException(e);
        }

    }}
