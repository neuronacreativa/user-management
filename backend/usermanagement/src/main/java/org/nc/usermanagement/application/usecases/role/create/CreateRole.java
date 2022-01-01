package org.nc.usermanagement.application.usecases.role.create;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;

public class CreateRole {

    public CreateRoleOut create(CreateRoleIn createRoleIn, RoleRepository roleRepository) throws CreateRoleException {

        if (!createRoleIn.getRole().getRoleName().getRoleName().equals("ROLE_SUPER_ADMIN")) {
            throw new CreateRoleException("This is bullshit");
        }

        roleRepository.save(createRoleIn.getRole());

        return new CreateRoleOut(createRoleIn);
    }
}
