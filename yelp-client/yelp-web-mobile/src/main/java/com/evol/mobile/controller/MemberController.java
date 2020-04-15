package com.evol.mobile.controller;

import com.evol.mobile.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("users/{id}")
    public User findById(@PathVariable Long id){
        User user = restTemplate.getForObject("http://yelp-provider-usc/users/find/{id}", User.class, id);
        return user;
    }


    public User findByIdFallback(Long id,  Throwable throwable){
        log.error("进入回退方法", throwable);
        return new User(id, "默认用户", "默认密码", "默认昵称");
    }
}
