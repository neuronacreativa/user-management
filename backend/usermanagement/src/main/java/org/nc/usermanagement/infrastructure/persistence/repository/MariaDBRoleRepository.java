package org.nc.usermanagement.infrastructure.persistence.repository;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.ReadRoleException;
import org.nc.usermanagement.application.usecases.role.read.RoleNotFoundException;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.model.RoleModel;
import org.nc.usermanagement.infrastructure.persistence.repository.jpa.JpaRoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MariaDBRoleRepository implements RoleRepository {

    @Autowired
    private JpaRoleModelRepository jpaRoleModelRepository;

    @Override
    public void save(Role role) throws CreateRoleException {
        try{
            jpaRoleModelRepository.save(new RoleModel(role));
        } catch (IllegalArgumentException e) {
            throw new CreateRoleException(e);
        }
    }

    @Override
    public Role findByUuid(String uuid) throws EntityException, ValueObjectException, ReadRoleException {
        Optional<RoleModel> roleModel = jpaRoleModelRepository.findByUuid(uuid);

        if (roleModel.isEmpty())
            throw new RoleNotFoundException();

        return roleModel.get().getRole();
    }

    @Override
    public void delete(Role role) {
        // TODO
    }
}
