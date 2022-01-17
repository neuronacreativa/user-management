package org.nc.usermanagement.infrastructure.spring.config;

import org.nc.usermanagement.application.usecases.role.create.CreateRole;
import org.nc.usermanagement.application.usecases.role.delete.DeleteRoleByRoleName;
import org.nc.usermanagement.application.usecases.role.delete.DeleteRoleByUuid;
import org.nc.usermanagement.application.usecases.role.read.FindRoleByRoleName;
import org.nc.usermanagement.application.usecases.role.read.FindRoleByUuid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {

    @Bean
    public CreateRole getCreateRole() {
        return new CreateRole(
                getFindRoleByRoleName()
        );
    }

    @Bean
    public FindRoleByRoleName getFindRoleByRoleName() {
        return new FindRoleByRoleName();
    }

    @Bean
    public FindRoleByUuid getFindRoleByUuid() {
        return new FindRoleByUuid();
    }

    @Bean
    public DeleteRoleByRoleName getDeleteRoleByRoleName() {
        return new DeleteRoleByRoleName();
    }

    @Bean
    public DeleteRoleByUuid getDeleteRoleByUuid() {
        return new DeleteRoleByUuid();
    }
}
