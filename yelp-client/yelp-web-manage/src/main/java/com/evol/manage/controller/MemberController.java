package com.evol.manage.controller;

import com.evol.manage.feign.UserFeignClient;
import com.evol.manage.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/member")
@RestController
@Slf4j
public class MemberController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("users/{id}")
    public User findById(@PathVariable Long id){
        User user = restTemplate.getForObject("http://yelp-provider-usc/users/find/{id}", User.class, id);
        return user;
    }

    @HystrixCommand
    @GetMapping("users2/{id}")
    public User findById2(@PathVariable Long id){
        User user = userFeignClient.findById(id);
        return user;
    }

    @GetMapping("users2/findByPwd")
    public User findByPwd(String username, String password){
        User user = userFeignClient.findByPwd(username, password);
        return user;
    }

    @HystrixCommand(defaultFallback = "getUserFallback")
    @GetMapping("users/getUser/{id}")
    public User getUser(@PathVariable Long id){
        User user = userFeignClient.getUser(id);
        return user;
    }

    public User findByIdFallback(Long id,  Throwable throwable){
        log.error("进入回退方法", throwable);
        return new User(id, "默认用户", "默认密码", "默认昵称");
    }

    public User getUserFallback(){
        return new User(0L, "默认用户", "默认密码", "默认昵称");
    }


}
