package org.nc.usermanagement.application.usecases.user.update;

import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleOut;
import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.read.FindUserByUuid;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserByUuidIn;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserOut;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.application.usecases.user.update.dto.UpdateUserIn;
import org.nc.usermanagement.application.usecases.user.update.dto.UpdateUserOut;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.ArrayList;
import java.util.List;

public class UpdateUser {

    private final FindUserByUuid findUserByUuid;

    public UpdateUser(FindUserByUuid findUserByUuid) {
        this.findUserByUuid = findUserByUuid;
    }

    private User createUserFromFindUserOut(FindUserOut findUserOut)
            throws EntityException, ValueObjectException {

        List<Role> roles = new ArrayList<>();

        for (FindRoleOut findRoleOutAux : findUserOut.getFindRoleOuts()) {
            roles.add(
                    new Role(
                            findRoleOutAux.getUuid(),
                            findRoleOutAux.getRoleName(),
                            findRoleOutAux.getPriority()
                    )
            );
        }

        return new User(
                findUserOut.getUuid(),
                findUserOut.getUserName(),
                findUserOut.getPassword(),
                findUserOut.getEmail(),
                roles
        );
    }

    public UpdateUserOut update(UpdateUserIn updateUserIn, UserRepository userRepository)
            throws ValueObjectException, UseCaseException, EntityException {

        try {
            FindUserOut findUserOut = findUserByUuid.findUserByUuid(
                    new FindUserByUuidIn(
                            updateUserIn.getUuid().getUuid()
                    ),
                    userRepository
            );

            userRepository.save(
                    createUserFromFindUserOut(findUserOut)
            );
        } catch (UserNotFoundException userNotFoundException) {
            throw new UseCaseException(userNotFoundException);
        }

        return new UpdateUserOut();
    }
}
