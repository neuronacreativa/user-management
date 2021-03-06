package org.nc.usermanagement.infrastructure.persistence.db.repository;

import org.nc.usermanagement.application.usecases.role.RoleRepository;
import org.nc.usermanagement.application.usecases.role.create.exception.CreateRoleException;
import org.nc.usermanagement.application.usecases.role.read.exception.RoleNotFoundException;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaRoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DBRoleRepository implements RoleRepository {

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
    public Role findByUuid(String uuid) throws EntityException, ValueObjectException, RoleNotFoundException {
        Optional<RoleModel> roleModel = jpaRoleModelRepository.findByUuid(uuid);

        if (roleModel.isEmpty())
            throw new RoleNotFoundException();

        return roleModel.get().getRole();
    }

    @Override
    public List<Role> findByUuidIn(List<String> uuids) throws EntityException, ValueObjectException, RoleNotFoundException {
        List<RoleModel> roleModels = jpaRoleModelRepository.findByUuidIn(uuids);

        if (roleModels.isEmpty())
            throw new RoleNotFoundException();

        List<Role> roles = new ArrayList<>();
        for (RoleModel roleModel : roleModels) {
            roles.add(
                    roleModel.getRole()
            );
        }

        return roles;
    }

    @Override
    public Role findByRoleName(String roleName) throws EntityException, ValueObjectException, RoleNotFoundException {
        Optional<RoleModel> roleModel = jpaRoleModelRepository.findByRoleName(roleName);

        if (roleModel.isEmpty())
            throw new RoleNotFoundException();

        return roleModel.get().getRole();
    }

    @Override
    public void update(Role role) throws RoleNotFoundException {
        Optional<RoleModel> roleModel = jpaRoleModelRepository.findByUuid(
                role.getUuid().getUuid()
        );

        if (roleModel.isEmpty())
            throw new RoleNotFoundException();

        roleModel.get().setRoleModelByRole(role);

        jpaRoleModelRepository.save(roleModel.get());
    }

    @Override
    public void delete(Role role) {
        jpaRoleModelRepository.delete(new RoleModel(role));
    }
}
