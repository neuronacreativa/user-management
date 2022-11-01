package org.nc.usermanagement.application.usecases.role.delete;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.delete.dto.DeleteRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class DeleteRoleByUuid {

    public void delete(DeleteRoleByUuidIn deleteRoleByUuidIn, RoleRepository roleRepository)
            throws EntityException, RoleNotFoundException, ValueObjectException {
        roleRepository.delete(
                roleRepository.findByUuid(
                        deleteRoleByUuidIn.getUuid().getUuid()
                )
        );
    }

}
