package org.nc.usermanagement.application.usecases.user.create;

import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;
import org.nc.usermanagement.application.usecases.user.read.FindUserByUserName;
import org.nc.usermanagement.application.usecases.user.read.dto.FindUserByUserNameIn;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.ArrayList;
import java.util.List;

public class CreateUser {

    private final FindUserByUserName findUserByUserName;

    public CreateUser(FindUserByUserName findUserByUserName) {
        this.findUserByUserName = findUserByUserName;
    }

    public CreateUserOut create(CreateUserIn createUserIn, UserRepository userRepository, RoleRepository roleRepository) throws UseCaseException, EntityException, ValueObjectException {

        Role role = roleRepository.findByUuid(createUserIn.getReadByUuidIns().getUuid().getUuid());

        try {
            findUserByUserName.findUserByUserName(
                    new FindUserByUserNameIn(
                            createUserIn.getUserName().getUserName()
                    ), userRepository
            );
        } catch (UserNotFoundException ignored) {
            userRepository.save(
                    new User(
                            createUserIn.getUuid().getUuid(),
                            createUserIn.getUserName().getUserName(),
                            createUserIn.getPassword().getPassword(),
                            createUserIn.getEmail().getEmail(),
                            role
                    )
            );
        }

        return new CreateUserOut(createUserIn);
    }

}
