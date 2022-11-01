package org.nc.usermanagement.infrastructure.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserManagementControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            UserManagementException.class
    })
    protected ResponseEntity<Object> handleCreateRoleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
