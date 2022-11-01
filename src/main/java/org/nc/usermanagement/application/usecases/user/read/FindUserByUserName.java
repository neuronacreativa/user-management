package org.nc.usermanagement.application.usecases.user.read;

import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserByUserNameIn;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserOut;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindUserByUserName {

    public FindUserOut findUserByUserName(
            FindUserByUserNameIn findUserByUserNameIn, UserRepository userRepository
    )
            throws UserNotFoundException, EntityException, ValueObjectException
    {
            return new FindUserOut(
                    userRepository.findByUserName(
                            findUserByUserNameIn.getUserName().getUserName()
                    )
            );
    }
}
