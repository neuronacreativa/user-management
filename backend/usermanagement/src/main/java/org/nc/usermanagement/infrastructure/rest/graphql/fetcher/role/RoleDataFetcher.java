package org.nc.usermanagement.infrastructure.rest.graphql.fetcher.role;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaRoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDataFetcher implements DataFetcher<RoleModel> {

    @Autowired
    private JpaRoleModelRepository jpaRoleModelRepository;

    @Override
    public RoleModel get(DataFetchingEnvironment dataFetchingEnvironment) {
        String uuid = dataFetchingEnvironment.getArgument("uuid");
        return jpaRoleModelRepository.findByUuid(uuid).orElse(null);
    }
}