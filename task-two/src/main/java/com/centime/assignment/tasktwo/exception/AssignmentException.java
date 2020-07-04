package com.centime.assignment.tasktwo.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author gvaddepally on 03/07/20
 */
@Getter
@Setter
@ToString
public class AssignmentException extends RuntimeException {
    private String message;
    private int httpStatusCode;
    private int errorCode;

    public AssignmentException(String message) {
        this(message, null);
    }

    public AssignmentException(String message, Throwable cause) {
        this(message, 0, 0, cause);
    }

    public AssignmentException(Throwable cause) {
        this(cause.getMessage(), 0, 0, cause);
    }

    public AssignmentException(String message, int errorCode) {
        this(message, errorCode, null);
    }

    public AssignmentException(String message, int errorCode, Throwable cause) {
        this(message, errorCode, 0, null);
    }

    public AssignmentException(String message, int errorCode, int httpStatusCode) {
        this(message, errorCode, httpStatusCode, null);
    }

    public AssignmentException(String message, int errorCode, int httpStatusCode, Throwable cause) {
        if (StringUtils.isBlank(message)) {
            message = "Something went wrong, please try again after some time or contact tech support.";
        }
        if (errorCode == 0) {
            errorCode = 1000;
        }
        if (httpStatusCode == 0) {
            httpStatusCode = 400;
        }
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }
}
