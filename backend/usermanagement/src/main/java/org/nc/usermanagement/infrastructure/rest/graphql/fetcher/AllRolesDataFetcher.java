package org.nc.usermanagement.infrastructure.rest.graphql.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaRoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllRolesDataFetcher implements DataFetcher<List<RoleModel>> {

    @Autowired
    private JpaRoleModelRepository jpaRoleModelRepository;

    @Override
    public List<RoleModel> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return jpaRoleModelRepository.findAll();
    }
}