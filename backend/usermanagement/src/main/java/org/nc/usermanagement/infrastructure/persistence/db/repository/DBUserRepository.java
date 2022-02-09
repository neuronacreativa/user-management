package org.nc.usermanagement.infrastructure.persistence.db.repository;

import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.nc.usermanagement.infrastructure.persistence.db.model.UserModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DBUserRepository implements UserRepository {

    @Autowired
    private JpaUserModelRepository jpaUserModelRepository;

    @Override
    public void save(User user) {

        // TODO: Set userModel attributes from user

        UserModel userModel = new UserModel();
        jpaUserModelRepository.save(userModel);
    }

    @Override
    public User findByUuid(String uuid)
            throws EntityException, ValueObjectException, UserNotFoundException
    {
        Optional<UserModel> userModel = jpaUserModelRepository.findByUuid(uuid);

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
