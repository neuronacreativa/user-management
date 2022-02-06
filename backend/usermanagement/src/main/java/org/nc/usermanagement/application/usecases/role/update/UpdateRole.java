package org.nc.usermanagement.application.usecases.role.update;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleIn;
import org.nc.usermanagement.application.usecases.role.update.dto.UpdateRoleOut;

public class UpdateRole {

    public UpdateRoleOut update(UpdateRoleIn updateRoleIn, RoleRepository roleRepository)
            throws RoleNotFoundException {

        roleRepository.update(
                updateRoleIn.getRole()
        );

        return new UpdateRoleOut(updateRoleIn);
    }

}
