package org.nc.usermanagement.infrastructure.rest.graphql.provider;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.nc.usermanagement.infrastructure.persistence.db.model.RoleModel;
import org.nc.usermanagement.infrastructure.persistence.db.repository.jpa.JpaRoleModelRepository;
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
import java.util.stream.Stream;

@Component
public class GraphQLProvider {

    @Autowired
    private JpaRoleModelRepository jpaRoleModelRepository;
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
        loadDataIntoHSQL();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allRoles", allRolesDataFetcher)
                        .dataFetcher("role", roleDataFetcher))
                .build();
    }

    private void loadDataIntoHSQL() {
        Stream.of(RoleModel.builder().id(1).uuid("firstUuid").roleName("ROLE_TEST_USER").priority(0).build(),
                RoleModel.builder().id(2).uuid("secondUuid").roleName("ROLE_SUPER_USER").priority(1).build()
        ).forEach(roleModel -> jpaRoleModelRepository.save(roleModel));
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }


}