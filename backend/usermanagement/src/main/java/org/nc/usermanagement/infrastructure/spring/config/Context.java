package org.nc.usermanagement.infrastructure.spring.config;

import org.nc.usermanagement.infrastructure.persistence.db.repository.DBRoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {

    @Bean
    public DBRoleRepository getRoleRepository() {
        return new DBRoleRepository();
    }

}
