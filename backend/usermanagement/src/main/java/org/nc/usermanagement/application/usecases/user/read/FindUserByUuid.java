package org.nc.usermanagement.application.usecases.user.read;

import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserByUuidIn;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserOut;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindUserByUuid {

    public FindUserOut findUserByUuid(FindUserByUuidIn findUserByUuidIn, UserRepository userRepository)
            throws UserNotFoundException, EntityException, ValueObjectException
    {
        return new FindUserOut(
                userRepository.findByUuid(
                        findUserByUuidIn.getUuid().getUuid()
                )
        );
    }
}
