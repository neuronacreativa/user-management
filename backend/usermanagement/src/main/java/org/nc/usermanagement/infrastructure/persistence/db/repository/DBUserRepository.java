package org.nc.usermanagement.infrastructure.persistence.db.repository;

import org.jetbrains.annotations.NotNull;
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

        UserModel userModel = new UserModel();
        userModel.setUuid(user.getUuid().getUuid());
        userModel.setUserName(user.getUserName().getUserName());
        userModel.setPassword(user.getPassword().getPassword());
        userModel.setEmail(user.getEmail().getEmail());

        for (Role role : user.getRoles()) {
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
        }

        userModel.setUserRoleModels(userRoleModelList);

        jpaUserModelRepository.save(userModel);
    }

    @Override
    public User findByUuid(String uuid)
            throws EntityException, ValueObjectException, UserNotFoundException
    {
        Optional<UserModel> userModel = jpaUserModelRepository.findByUuid(uuid);

        return getUser(userModel);
    }

    @Override
    public User findByUserName(String userName)
            throws UserNotFoundException, EntityException, ValueObjectException
    {
        Optional<UserModel> userModel = jpaUserModelRepository.findByUserName(userName);

        return getUser(userModel);
    }

    @NotNull
    private User getUser(Optional<UserModel> userModel) throws UserNotFoundException, ValueObjectException, EntityException {
        if (userModel.isEmpty())
            throw new UserNotFoundException();

        List<UserRoleModel> userRoleModels = userModel.get().getUserRoleModels();
        List<Role> roles = new ArrayList<>();

        for (UserRoleModel userRoleModel : userRoleModels) {
            roles.add(
                    userRoleModel.getRoleModel().getRole()
            );
        }

        return new User(
                userModel.get().getUuid(),
                userModel.get().getUserName(),
                userModel.get().getPassword(),
                userModel.get().getEmail(),
                roles
        );
    }

}
