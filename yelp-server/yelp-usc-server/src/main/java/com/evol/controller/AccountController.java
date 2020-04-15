package com.evol.controller;

import com.evol.annotation.AuthToken;
import com.evol.domain.model.Admin;
import com.evol.domain.model.ResponseTemplate;
import com.evol.service.AdminService;
import com.evol.utils.ConstantKit;
import com.evol.utils.Md5TokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AdminService adminService;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @RequestMapping("welcome")
    public ResponseTemplate welcome(){
        return ResponseTemplate.builder().code(200).message("welcome ok").data(null).build();
    }

    @RequestMapping("login")
    public ResponseTemplate login(String username, String password){
        logger.info("username:"+username+"      password:"+password);
        Admin admin = adminService.getAdminByPwd(username, password);
        if(admin == null){
            return ResponseTemplate.builder()
                    .code(200)
                    .message("username or password error")
                    .data(null)
                    .build();
        }
        logger.info("admin:"+ admin.getUsername());

        String token = tokenGenerator.generate(username, password);
//        redisTemplate.opsForValue().set(username, token, ConstantKit.TOKEN_EXPIRE_TIME);
//        redisTemplate.opsForValue().set(token, username, ConstantKit.TOKEN_EXPIRE_TIME);
        stringRedisTemplate.opsForValue().set(username, token, ConstantKit.TOKEN_EXPIRE_TIME);
        stringRedisTemplate.opsForValue().set(token, username, ConstantKit.TOKEN_EXPIRE_TIME);
        Long currentTime = System.currentTimeMillis();
        //redisTemplate.opsForValue().set(token + username, currentTime.toString());
        stringRedisTemplate.opsForValue().set(token + username, currentTime.toString());


        Map<String, String> result = new HashMap<>();
        result.put("status", "登录成功");
        result.put("token", token);

        return ResponseTemplate.builder()
                .code(200)
                .message("登录成功")
                .data(result)
                .build();

    }


    @RequestMapping(value = "test", method = RequestMethod.GET)
    @AuthToken
    public ResponseTemplate test() {

        logger.info("已进入test路径");

        return ResponseTemplate.builder()
                .code(200)
                .message("Success")
                .data("test url")
                .build();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ResponseTemplate login(String username, String password) {
//
//        logger.info("username:"+username+"      password:"+password);
//
//        User user = userMapper.getUser(username,password);
//
//        logger.info("user:"+user);
//
//        JSONObject result = new JSONObject();
//        if (user != null) {
//
//            Jedis jedis = new RedisProperties.Jedis(host, port);
//            String token = tokenGenerator.generate(username, password);
//            jedis.set(username, token);
//            //设置key生存时间，当key过期时，它会被自动删除，时间是秒
//            jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
//            jedis.set(token, username);
//            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
//            Long currentTime = System.currentTimeMillis();
//            jedis.set(token + username, currentTime.toString());
//
//            //用完关闭
//            jedis.close();
//
//            result.put("status", "登录成功");
//            result.put("token", token);
//        } else {
//            result.put("status", "登录失败");
//        }
//
//        return ResponseTemplate.builder()
//                .code(200)
//                .message("登录成功")
//                .data(result)
//                .build();
//
//    }

}
