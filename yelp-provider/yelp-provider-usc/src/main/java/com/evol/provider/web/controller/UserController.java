package com.evol.provider.web.controller;

import com.evol.provider.model.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RequestMapping("/users")
@RestController
public class UserController {

    private String url;

    @GetMapping("find/{id}")
    public User findById(HttpServletRequest httpReq, @PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setNick("zhagnsan" + id);
        user.setUsername("name_zhangshan" + id);
        String url = httpReq.getRequestURL().toString();
        String addr = httpReq.getRemoteAddr();
        System.out.println(String.format("request url : %s, addr : %s，Time：%s", url, addr, (new SimpleDateFormat("HH:mm:ss")).format(new Date())));
        return user;
    }

    @GetMapping("findByPwd?username={username}&password={password}")
    public User findByPwd(HttpServletRequest httpReq, @PathVariable String username, @PathVariable String password){
        User user = new User();
        user.setId(1);
        user.setNick(username + "_nick");
        user.setUsername(username);
        user.setPassword(password);
        String url = httpReq.getRequestURL().toString();
        String addr = httpReq.getRemoteAddr();
        System.out.println(String.format("request url : %s, addr : %s，Time：%s", url, addr, (new SimpleDateFormat("HH:mm:ss")).format(new Date())));
        return user;
    }

    @GetMapping("getUser/{id}")
    public User getUser(HttpServletRequest httpReq, @PathVariable Long  id) throws InterruptedException {
        //Thread.sleep(2000);
        User user = new User();
        user.setId(id);
        user.setNick("zhagnsan" + id);
        user.setUsername("name_zhangshan" + id);
        String url = httpReq.getRequestURL().toString();
        String addr = httpReq.getRemoteAddr();
        System.out.println(String.format("request url : %s, addr : %s，Time：%s", url, addr, (new SimpleDateFormat("HH:mm:ss")).format(new Date())));
        return user;
    }
}
