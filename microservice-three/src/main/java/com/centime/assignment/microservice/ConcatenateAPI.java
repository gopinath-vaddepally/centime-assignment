package com.centime.assignment.microservice;

import com.centime.assignment.microservice.exception.AssignmentException;
import com.centime.assignment.microservice.pojo.NameDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * @author gvaddepally on 03/07/20
 */
@RestController
@RequestMapping(value = "/api/v1/assignment/concatenate")
public class ConcatenateAPI {

    private static final Logger logger = LoggerFactory.getLogger(ConcatenateAPI.class);

    @PostMapping
    public String concatenate(@RequestBody NameDTO nameDTO){
        logger.info("request payload = {}",nameDTO);
        if(StringUtils.isBlank(nameDTO.getName())){
            throw new AssignmentException("name is required",404,400);
        }
        if(StringUtils.isBlank(nameDTO.getSurname())){
            throw new AssignmentException("surname is required",404,400);
        }
        return String.join(" ",nameDTO.getName(),nameDTO.getSurname());
    }
}
