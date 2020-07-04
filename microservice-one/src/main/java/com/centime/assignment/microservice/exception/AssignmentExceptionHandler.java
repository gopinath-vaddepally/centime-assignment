package com.centime.assignment.microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author gvaddepally on 03/07/20
 */
@ControllerAdvice
public class AssignmentExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest) {
        AssignmentException assignmentException = null;
        if (ex instanceof AssignmentException) {
            assignmentException = (AssignmentException) ex;
        } else {
            assignmentException = new AssignmentException(ex.getMessage(), ex);
        }
        int httpStatusCode = assignmentException.getHttpStatusCode();
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(assignmentException);
        return new ResponseEntity(exceptionResponseDTO, HttpStatus.valueOf(httpStatusCode));
    }
}
