package com.user.userservers.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "eureka-client")
public interface UserService {
    @RequestMapping(value = "getuser", method = RequestMethod.GET)
    public Object getUser();
}
