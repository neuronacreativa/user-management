package org.nc.usermanagement.application.usecases.role.create;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleIn;
import org.nc.usermanagement.application.usecases.role.create.dto.CreateRoleOut;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.create.exception.RoleAlreadyExistsException;
import org.nc.usermanagement.application.usecases.role.read.FindRoleByRoleName;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByRoleNameIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

import javax.transaction.Transactional;

@Transactional
public class CreateRole {

    private final FindRoleByRoleName findRoleByRoleName;

    public CreateRole(FindRoleByRoleName findRoleByRoleName) {
        this.findRoleByRoleName = findRoleByRoleName;
    }

    public CreateRoleOut create(CreateRoleIn createRoleIn, RoleRepository roleRepository)
            throws CreateRoleException, EntityException, ValueObjectException {

        try {
            findRoleByRoleName.findByRoleName(
                    new FindRoleByRoleNameIn(
                            createRoleIn.getRole().getRoleName().getRoleName()
                    ), roleRepository
            );
        } catch (RoleNotFoundException e) {
            roleRepository.save(createRoleIn.getRole());
            return new CreateRoleOut(createRoleIn);
        }
        throw new RoleAlreadyExistsException();
    }
}
