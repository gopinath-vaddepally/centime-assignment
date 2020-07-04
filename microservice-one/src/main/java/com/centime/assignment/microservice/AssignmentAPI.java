package com.centime.assignment.microservice;

import com.centime.assignment.microservice.exception.AssignmentException;
import com.centime.assignment.microservice.pojo.NameDTO;
import com.centime.assignment.microservice.pojo.ResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gvaddepally on 03/07/20
 */
@RestController
@RequestMapping(value = "/api/v1/assignment")
public class AssignmentAPI {
    private static final Logger logger = LoggerFactory.getLogger(AssignmentAPI.class);

    @Autowired
    private MicroserviceTwoInvocationProxy microServiceTwoInvocationProxy;

    @Autowired
    private MicroserviceThreeInvocationProxy microserviceThreeInvocationProxy;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get() {
        logger.info("get method is called");
        Map<String, String> response = new HashMap<String, String>() {{
            put("status", "up");
        }};
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> post(@RequestBody NameDTO nameDTO) {
        logger.info("post method is called with request body {}",nameDTO);
        if (StringUtils.isBlank(nameDTO.getName())) {
            throw new AssignmentException("name is mandatory in payload", 400, 400);
        }
        if (StringUtils.isBlank(nameDTO.getSurname())) {
            throw new AssignmentException("surname is mandatory in payload", 400, 400);
        }
        String hello = microServiceTwoInvocationProxy.getHello();
        String concatenantedString = microserviceThreeInvocationProxy.getConcatenantedString(nameDTO);
        String result = String.join(" ", hello, concatenantedString);
        ResponseDTO responseDTO = new ResponseDTO().setResult(result);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
