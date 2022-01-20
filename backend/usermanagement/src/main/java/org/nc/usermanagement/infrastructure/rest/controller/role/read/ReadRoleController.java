package org.nc.usermanagement.infrastructure.rest.controller.role.read;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadRoleController {

    @Autowired
    private GraphQL graphQL;

    @PostMapping("roles/find")
    public ResponseEntity<Object> movies(@RequestBody String query) {
        ExecutionResult execute = graphQL.execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
