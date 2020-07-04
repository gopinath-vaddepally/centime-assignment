package com.centime.assignment.tasktwo.exception;

/**
 * @author gvaddepally on 03/07/20
 */
public class ExceptionResponseDTO {
    private String message;
    private int errorCode;
    private AssignmentException assignmentException;

    public ExceptionResponseDTO(AssignmentException assignmentException){
        this.message = assignmentException.getMessage();
        this.errorCode = assignmentException.getErrorCode();
    }

    public String getMessage() {
        return message;
    }

    public ExceptionResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ExceptionResponseDTO setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Override
    public String toString() {
        return "ExceptionResponseDTO{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                ", assignmentException=" + assignmentException +
                '}';
    }
}
