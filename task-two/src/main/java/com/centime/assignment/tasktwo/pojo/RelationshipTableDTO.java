package com.centime.assignment.tasktwo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @author gvaddepally on 04/07/20
 */
@Entity
@Table(name = "RelationshipTable")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelationshipTableDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long parentid;

    private String color;

    public Long getId() {
        return id;
    }

    public RelationshipTableDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RelationshipTableDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public RelationshipTableDTO setColor(String color) {
        this.color = color;
        return this;
    }

    public Long getParentid() {
        return parentid;
    }

    public RelationshipTableDTO setParentid(Long parentid) {
        this.parentid = parentid;
        return this;
    }

    @Override
    public String toString() {
        return "RelationshipTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
