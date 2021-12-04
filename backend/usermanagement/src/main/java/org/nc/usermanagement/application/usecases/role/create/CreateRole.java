package org.nc.usermanagement.application.usecases.role.create;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.domain.entity.Role;

public class CreateRole {

    private final RoleRepository roleRepository;

    public CreateRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void create(Role role) throws CreateRoleException {
        this.roleRepository.save(role);
    }
}
