package org.nc.usermanagement.application.usecases.user.create;

import org.nc.usermanagement.application.usecases.UseCaseException;
import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.ReadByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserIn;
import org.nc.usermanagement.application.usecases.user.create.dto.CreateUserOut;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import java.util.ArrayList;
import java.util.List;

public class CreateUser {

    public CreateUserOut create(CreateUserIn createUserIn, UserRepository userRepository, RoleRepository roleRepository) throws UseCaseException, EntityException, ValueObjectException {

        List<Role> roleList = new ArrayList<>();

        for (ReadByUuidIn readByUuidIn : createUserIn.getReadByUuidIns()) {
            try {
                roleList.add(
                        roleRepository.findByUuid(
                                readByUuidIn.getUuid().getUuid()
                        )
                );
            } catch (EntityException | ValueObjectException | RoleNotFoundException e) {
                throw new UseCaseException(e);
            }
        }

        userRepository.save(
                new User(
                        createUserIn.getUuid().getUuid(),
                        createUserIn.getUserName().getUserName(),
                        createUserIn.getPassword().getPassword(),
                        createUserIn.getEmail().getEmail(),
                        roleList
                )
        );

        return new CreateUserOut(createUserIn);
    }

}
