package org.nc.usermanagement.infrastructure.rest.graphql.fetcher.user;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.nc.usermanagement.infrastructure.persistence.db.model.UserModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataFetcher implements DataFetcher<UserModel> {

    @Autowired
    private JpaUserModelRepository jpaUserModelRepository;

    @Override
    public UserModel get(DataFetchingEnvironment dataFetchingEnvironment) {
        String uuid = dataFetchingEnvironment.getArgument("uuid");
        return jpaUserModelRepository.findByUuid(uuid).orElse(null);
    }
}