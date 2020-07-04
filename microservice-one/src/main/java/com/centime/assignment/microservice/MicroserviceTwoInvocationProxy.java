package com.centime.assignment.microservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author gvaddepally on 03/07/20
 */
@FeignClient(name = "microservice-two")
@RibbonClient(name = "microservice-two")
public interface MicroserviceTwoInvocationProxy {

    @GetMapping("api/v1/assignment/hello")
    public String getHello();
}
