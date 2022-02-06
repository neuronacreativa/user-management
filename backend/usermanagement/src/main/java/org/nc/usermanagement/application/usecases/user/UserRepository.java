package org.nc.usermanagement.application.usecases.user;

import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;

public interface UserRepository {
    void save(User user);
    Role findByUuid(String uuid);
    Role findByUserName(String roleName);
}
