package org.nc.usermanagement.application.usecases.role.create;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;

public class CreateRole {

    public void create(CreateRoleIn createRoleIn, RoleRepository roleRepository) throws CreateRoleException {
        roleRepository.save(createRoleIn.getRole());
    }
}
