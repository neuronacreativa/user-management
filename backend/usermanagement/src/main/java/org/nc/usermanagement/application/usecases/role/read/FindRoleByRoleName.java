package org.nc.usermanagement.application.usecases.role.read;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByRoleNameIn;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleOut;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindRoleByRoleName {

    public FindRoleOut findByRoleName(
            FindRoleByRoleNameIn findRoleByRoleNameIn, RoleRepository roleRepository
    )
            throws EntityException, RoleNotFoundException, ValueObjectException
    {
        return new FindRoleOut(
                roleRepository.findByRoleName(
                        findRoleByRoleNameIn.getRoleName().getRoleName()
                )
        );
    }
}
