package com.centime.assignment.microservice;

import com.centime.assignment.microservice.pojo.NameDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author gvaddepally on 03/07/20
 */
@FeignClient(name = "microservice-three")
@RibbonClient(name = "microservice-three")
public interface MicroserviceThreeInvocationProxy {
    @PostMapping("api/v1/assignment/concatenate")
    public String getConcatenantedString(NameDTO nameDTO);
}
