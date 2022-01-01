package org.nc.usermanagement.infrastructure.rest.role.controller;

import org.nc.usermanagement.application.usecases.role.create.CreateRoleException;
import org.nc.usermanagement.domain.exception.EntityException;
import org.nc.usermanagement.domain.exception.ValueObjectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CreateRoleControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            CreateRoleException.class,
            EntityException.class, ValueObjectException.class
    })
    protected ResponseEntity<Object> handleCreateRoleException() {
        return ResponseEntity.badRequest().build();
    }
}
