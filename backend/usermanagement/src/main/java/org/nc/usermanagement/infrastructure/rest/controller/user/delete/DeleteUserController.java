package org.nc.usermanagement.infrastructure.rest.controller.user.delete;

import org.nc.usermanagement.application.usecases.user.delete.DeleteUser;
import org.nc.usermanagement.application.usecases.user.delete.DeleteUserIn;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.repository.DBUserRepository;
import org.nc.usermanagement.infrastructure.rest.exception.UserManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserController {

    @Autowired
    private DeleteUser deleteUser;

    @Autowired
    private DBUserRepository dbUserRepository;

    @DeleteMapping("user/{uuid}")
    public ResponseEntity<?> delete(
            @PathVariable String uuid
    ) throws UserManagementException
    {
        try {
            this.deleteUser.delete(
                    new DeleteUserIn(
                            uuid
                    ), dbUserRepository
            );
        } catch (UserNotFoundException | EntityException | ValueObjectException e) {
            throw new UserManagementException(e);
        }

        return ResponseEntity.ok().build();
    }

}
