package com.centime.assignment.microservice.pojo;

/**
 * @author gvaddepally on 03/07/20
 */
public class ResponseDTO {
    private String result;

    public String getResult() {
        return result;
    }

    public ResponseDTO setResult(String result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "result='" + result + '\'' +
                '}';
    }
}
