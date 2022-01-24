package org.nc.usermanagement.infrastructure.rest.graphql.provider;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.nc.usermanagement.infrastructure.rest.graphql.fetcher.AllRolesDataFetcher;
import org.nc.usermanagement.infrastructure.rest.graphql.fetcher.RoleDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class GraphQLProvider {

    @Autowired
    private AllRolesDataFetcher allRolesDataFetcher;

    @Autowired
    private RoleDataFetcher roleDataFetcher;

    @Value("classpath:schema.graphql")
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
                        .dataFetcher("allRoles", allRolesDataFetcher)
                        .dataFetcher("role", roleDataFetcher))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }


}