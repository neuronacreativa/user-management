package org.nc.usermanagement.application.usecases.role.read;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.ReadByRoleNameIn;
import org.nc.usermanagement.application.usecases.role.read.dto.ReadRoleOut;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class ReadRole {

    public ReadRoleOut findByRoleName(ReadByRoleNameIn readByRoleNameIn, RoleRepository roleRepository)
            throws EntityException, RoleNotFoundException, ValueObjectException {
        return new ReadRoleOut(
                roleRepository.findByRoleName(readByRoleNameIn.getRoleName().getRoleName())
        );
    }
}
