package com.centime.assignment.tasktwo.pojo;

import java.util.List;

/**
 * @author gvaddepally on 04/07/20
 */
public class ResponseDTO {
    private String name;
    private List<ResponseDTO> subClasses;

    public String getName() {
        return name;
    }

    public ResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<ResponseDTO> getSubClasses() {
        return subClasses;
    }

    public ResponseDTO setSubClasses(List<ResponseDTO> subClasses) {
        this.subClasses = subClasses;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "name='" + name + '\'' +
                ", subClasses=" + subClasses +
                '}';
    }
}
