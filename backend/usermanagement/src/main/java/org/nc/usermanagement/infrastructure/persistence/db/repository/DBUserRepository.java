package org.nc.usermanagement.infrastructure.persistence.db.repository;

import org.nc.usermanagement.application.usecases.user.UserRepository;
import org.nc.usermanagement.domain.entity.Role;
import org.nc.usermanagement.domain.entity.User;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DBUserRepository implements UserRepository {

    @Autowired
    private JpaUserModelRepository jpaUserModelRepository;

    @Override
    public void save(User user) {

    }

    @Override
    public Role findByUuid(String uuid) {
        return null;
    }

    @Override
    public Role findByUserName(String roleName) {
        return null;
    }
}
