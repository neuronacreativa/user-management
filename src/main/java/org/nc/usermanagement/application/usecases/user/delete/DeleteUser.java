package org.nc.usermanagement.application.usecases.user.delete;

import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import javax.transaction.Transactional;

@Transactional
public class DeleteUser {

    public void delete(DeleteUserIn deleteUserIn, UserRepository userRepository)
            throws UserNotFoundException, EntityException, ValueObjectException
    {
        userRepository.delete(
                userRepository.findByUuid(
                        deleteUserIn.getUuid().getUuid()
                )
        );
    }
}
