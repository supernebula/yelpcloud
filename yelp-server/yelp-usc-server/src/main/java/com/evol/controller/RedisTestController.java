package com.evol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


//https://www.jianshu.com/p/620a9b15a619
//https://www.iteye.com/blog/357029540-2389045
//https://blog.csdn.net/weixin_41990707/article/details/81295651
//https://yq.aliyun.com/articles/531067  阿里云Redis开发规范
@RequestMapping("redisTest")
@RestController
public class RedisTestController {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private String tokenKey = "access-token";

    @PostMapping("lg")
    public String lgtest(String username, Integer userId){

        String hk = username + "_" + userId + "_" +UUID.randomUUID().toString();
        Date date = new Date();
        SimpleDateFormat simFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        String val = simFormat.format(date);
        System.out.println("hk:");
        System.out.println(hk);
        stringRedisTemplate.opsForHash().put(tokenKey, hk, val);
        return "hk:" + hk + "  ,  val:" + val;
    }

    public String checkTest(HttpServletRequest request){
        return null;
    }

    @GetMapping("checkTest")
    public String checkTest(@RequestHeader("username") String username, @RequestHeader("userId") String userId,
                            @RequestHeader("token") String token){



        String hk = username + "_" + userId + "_" + token;

        Object val = stringRedisTemplate.opsForHash().get(tokenKey, hk);
        String valStr = (String)val;
        return valStr;
    }

    @DeleteMapping("deleteTest")
    public Long deleteTest(@RequestHeader("username") String username, @RequestHeader("userId") String userId,
                             @RequestHeader("token") String token){

        String hk = username + "_" + userId + "_" + token;
        Long number = stringRedisTemplate.opsForHash().delete(tokenKey, hk);
        return number;
    }

}
