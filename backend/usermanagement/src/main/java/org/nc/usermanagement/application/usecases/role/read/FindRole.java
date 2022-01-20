package org.nc.usermanagement.application.usecases.role.read;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleIn;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleOut;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindRole {

    public FindRoleOut find(FindRoleIn findRoleIn, RoleRepository roleRepository) throws EntityException, RoleNotFoundException, ValueObjectException {

        Role role = roleRepository.findByUuidAndRoleName(findRoleIn.getUuid(), findRoleIn.getRoleName());

        return new FindRoleOut(
                role.getUuid().getUuid(),
                role.getRoleName().getRoleName(),
                role.getPriority().getPriority()
        );
    }

}
