package org.nc.usermanagement.application.usecases.role.update;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleIn;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleOut;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public class UpdateRole {

    public UpdateRoleOut update(UpdateRoleIn updateRoleIn, RoleRepository roleRepository) throws CreateRoleException, EntityException, RoleNotFoundException, ValueObjectException {

        // TODO: Tests
        roleRepository.save(
                roleRepository.findByUuid(
                        updateRoleIn.getRole().getUuid().getUuid()
                )
        );

        return new UpdateRoleOut(updateRoleIn);
    }

}
