package org.nc.usermanagement.infrastructure.spring.config;

import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {

    @Bean
    public CreateRole getCreateRole() {
        return new CreateRole();
    }
}
