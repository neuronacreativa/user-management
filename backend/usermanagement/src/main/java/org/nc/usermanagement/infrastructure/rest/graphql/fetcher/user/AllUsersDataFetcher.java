package org.nc.usermanagement.infrastructure.rest.graphql.fetcher.user;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.nc.usermanagement.infrastructure.persistence.db.model.UserModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class AllUsersDataFetcher implements DataFetcher<Page<UserModel>> {

    @Autowired
    private JpaUserModelRepository jpaUserModelRepository;

    private static final String PAGE = "page";
    private static final String PAGE_SIZE = "pageSize";
    private static final String ORDER_TYPE = "orderType";

    private static final String ORDER_BY = "id";

    @Override
    public Page<UserModel> get(DataFetchingEnvironment dataFetchingEnvironment) {

        // TODO: Handle Exceptions

        Pageable pageable = PageRequest.of(
                dataFetchingEnvironment.getArgument(PAGE),
                dataFetchingEnvironment.getArgument(PAGE_SIZE),
                Sort.by(
                        Sort.Direction.fromString(
                                dataFetchingEnvironment.getArgument(ORDER_TYPE)
                        ),
                        ORDER_BY
                )
        );

        return jpaUserModelRepository.findAll(pageable);
    }
}