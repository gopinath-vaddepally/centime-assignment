package com.centime.assignment.microservice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author gvaddepally on 03/07/20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NameDTO {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public NameDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public NameDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public String toString() {
        return "NameDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
