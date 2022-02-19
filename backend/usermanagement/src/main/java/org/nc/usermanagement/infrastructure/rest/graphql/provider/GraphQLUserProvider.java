package org.nc.usermanagement.infrastructure.rest.graphql.provider;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.nc.usermanagement.infrastructure.rest.graphql.fetcher.user.AllUsersDataFetcher;
import org.nc.usermanagement.infrastructure.rest.graphql.fetcher.user.UserDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class GraphQLUserProvider {

    @Autowired
    private AllUsersDataFetcher allUsersDataFetcher;

    @Autowired
    private UserDataFetcher userDataFetcher;

    @Value("classpath:schemaUser.graphql")
    private Resource resource;

    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        File file = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allUsers", allUsersDataFetcher)
                        .dataFetcher("user", userDataFetcher))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }


}