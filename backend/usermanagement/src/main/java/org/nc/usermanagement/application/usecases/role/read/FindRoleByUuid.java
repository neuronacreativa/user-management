package org.nc.usermanagement.application.usecases.role.read;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.dto.ReadByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.dto.ReadRoleOut;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class FindRoleByUuid {

    public ReadRoleOut findRoleByUuid(ReadByUuidIn readByUuidIn, RoleRepository roleRepository)
            throws EntityException, RoleNotFoundException, ValueObjectException {
        return new ReadRoleOut(
                roleRepository.findByUuid(readByUuidIn.getUuid().getUuid())
        );
    }

}
