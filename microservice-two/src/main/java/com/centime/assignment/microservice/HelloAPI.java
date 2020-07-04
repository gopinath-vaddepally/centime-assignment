package com.centime.assignment.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gvaddepally on 03/07/20
 */
@RestController
@RequestMapping(value = "/api/v1/assignment/hello")
public class HelloAPI {

    private static final Logger logger = LoggerFactory.getLogger(HelloAPI.class);

    @GetMapping
    public String get(){
        logger.info("Hello api is called");
        return "Hello";
    }
}
