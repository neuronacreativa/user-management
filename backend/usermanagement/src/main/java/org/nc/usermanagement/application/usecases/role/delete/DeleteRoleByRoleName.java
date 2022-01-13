package org.nc.usermanagement.application.usecases.role.delete;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.delete.dto.DeleteRoleByRoleNameIn;
import org.nc.usermanagement.application.usecases.role.delete.dto.DeleteRoleByUuidIn;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class DeleteRoleByRoleName {

    public void delete(DeleteRoleByRoleNameIn deleteRoleByRoleNameIn, RoleRepository roleRepository)
            throws EntityException, RoleNotFoundException, ValueObjectException {
        roleRepository.delete(
                roleRepository.findByRoleName(
                        deleteRoleByRoleNameIn.getRoleName().getRoleName()
                )
        );
    }

}
