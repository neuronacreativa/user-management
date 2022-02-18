package org.nc.usermanagement.application.usecases.user;

import org.nc.usermanagement.application.usecases.user.read.exception.UserNotFoundException;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;

public interface UserRepository {
    void save(User user);
    User findByUuid(String uuid) throws EntityException, ValueObjectException, UserNotFoundException;
    User findByUserName(String roleName) throws UserNotFoundException, EntityException, ValueObjectException;
    void delete(User user) throws UserNotFoundException;
}
