package org.nc.usermanagement.infrastructure.persistence.db.repository;

import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.nc.usermanagement.infrastructure.persistence.db.model.UserModel;
import org.nc.usermanagement.infrastructure.persistence.db.model.UserRoleModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DBUserRepository implements UserRepository {

    @Autowired
    private JpaUserModelRepository jpaUserModelRepository;

    @Override
    public void save(User user) {

        List<UserRoleModel> userRoleModelList = new ArrayList<>();

        Role role = user.getRole();

        UserModel userModel = new UserModel();
        userModel.setUuid(user.getUuid().getUuid());
        userModel.setUserName(user.getUserName().getUserName());
        userModel.setPassword(user.getPassword().getPassword());
        userModel.setEmail(user.getEmail().getEmail());

        RoleModel roleModel = new RoleModel();
        roleModel.setUuid(role.getUuid().getUuid());
        roleModel.setRoleName(role.getRoleName().getRoleName());
        roleModel.setPriority(role.getPriority().getPriority());

        UserRoleModel userRoleModel = new UserRoleModel();
        userRoleModel.setUserModel(userModel);
        userRoleModel.setRoleModel(roleModel);

        userRoleModelList.add(
                userRoleModel
        );

        userModel.setUserRoleModels(userRoleModelList);

        jpaUserModelRepository.save(userModel);
    }

    @Override
    public User findByUuid(String uuid)
            throws EntityException, ValueObjectException, UserNotFoundException
    {
        Optional<UserModel> userModel = jpaUserModelRepository.findByUuid(uuid);

        if (userModel.isEmpty())
            throw new UserNotFoundException();

        RoleModel roleModel = userModel.get().getUserRoleModels().get(0).getRoleModel();

        // TODO: User must has a roles' list

        return new User(
                userModel.get().getUuid(),
                userModel.get().getUserName(),
                userModel.get().getPassword(),
                userModel.get().getEmail(),
                roleModel.getRole()
        );
    }

    @Override
    public User findByUserName(String userName)
            throws UserNotFoundException, EntityException, ValueObjectException
    {
        Optional<UserModel> userModel = jpaUserModelRepository.findByUserName(userName);

        if (userModel.isEmpty())
            throw new UserNotFoundException();

        // TODO: Create new User from userModel

        return new User(
                userModel.get().getUuid(),
                userModel.get().getUserName(),
                userModel.get().getPassword(),
                userModel.get().getEmail(),
                null
        );
    }

}
