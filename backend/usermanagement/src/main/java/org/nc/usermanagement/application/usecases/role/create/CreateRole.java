package org.nc.usermanagement.application.usecases.role.create;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;

public class CreateRole {

    private final RoleRepository roleRepository;

    public CreateRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void create(CreateRoleIn createRoleIn) throws CreateRoleException {
        this.roleRepository.save(createRoleIn.getRole());
    }
}
