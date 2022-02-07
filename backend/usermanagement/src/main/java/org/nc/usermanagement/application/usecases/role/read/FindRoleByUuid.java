package org.nc.usermanagement.application.usecases.role.read;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.dto.FindRoleOut;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindRoleByUuid {

    public FindRoleOut findRoleByUuid(FindRoleByUuidIn findRoleByUuidIn, RoleRepository roleRepository)
            throws EntityException, RoleNotFoundException, ValueObjectException {
        return new FindRoleOut(
                roleRepository.findByUuid(findRoleByUuidIn.getUuid().getUuid())
        );
    }

}
