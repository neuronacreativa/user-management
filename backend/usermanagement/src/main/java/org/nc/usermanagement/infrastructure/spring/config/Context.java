package org.nc.usermanagement.infrastructure.spring.config;

import org.nc.usermanagement.infrastructure.persistence.mariadb.repository.MariaDBRoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {

    @Bean
    public MariaDBRoleRepository getRoleRepository() {
        return new MariaDBRoleRepository();
    }

}
