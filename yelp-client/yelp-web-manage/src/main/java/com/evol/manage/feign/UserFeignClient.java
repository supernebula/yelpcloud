package com.evol.manage.feign;

import com.evol.manage.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Logger;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "yelp-provider-usc", configuration = UserFeignClient.UserFeignConfig.class)
@FeignClient(name = "yelp-provider-usc", fallback = UserFeignClientFallback.class)
//@FeignClient(name = "yelp-provider-usc", fallbackFactory = UserFeignClientFallbackFactory.class)
//@FeignClient(name = "yelp-provider-usc", fallbackFactory = UserFeignClientFallbackFactory.class, configuration = FeignDisableHystrixConfiguration.class)
public interface UserFeignClient {

    @GetMapping("/users/find/{id}")
    User findById(@PathVariable("id") Long id);

    @GetMapping("users/findByPwd?username={username}&password={password}")
    User findByPwd(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password);


    @GetMapping("users/getUser/{id}")
    User getUser(@PathVariable("id") Long id);


    /**
     * 该Feign Client的配置类，注意：
     * 1. 该类可以独立出去；
     * 2. 该类上也可添加@Configuration声明是一个配置类；
     * 配置类上也可添加@Configuration注解，声明这是一个配置类；
     * 但此时千万别将该放置在主应用程序上下文@ComponentScan所扫描的包中，
     * 否则，该配置将会被所有Feign Client共享，无法实现细粒度配置！
     * 个人建议：像我一样，不加@Configuration注解
     */
//    class UserFeignConfig {
//        @Bean
//        public Logger.Level logger(){
//            return Logger.Level.FULL;
//        }
//    }

}

@Component
class UserFeignClientFallback implements UserFeignClient{

    @Override
    public User findById(Long id){
        return new User(id, "F默认用户1", "F默认密码1", "F默认昵称1");
    }

    @Override
    public User findByPwd(String username, String password){
        return new User(0L, "F默认用户3", "F默认密码3", "F默认昵称3");
    }

    @Override
    public User getUser(Long  id){
        return new User(id, "F默认用户4", "F默认密码4", "F默认昵称4");
    }
}


@Component
@Slf4j
class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    public UserFeignClient create(Throwable throwable){
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                log.error("进入回退逻辑",  throwable);
                return new User(id,  "默认用户Factory", "默认密码Fac", "默认昵称Fac");
            }

            @Override
            public User findByPwd(String username, String password) {
                log.error("进入回退逻辑",  throwable);
                return new User(0L,  "默认用户Factory", "默认密码Fac", "默认昵称Fac");
            }

            @Override
            public User getUser(Long id) {
                log.error("进入回退逻辑",  throwable);
                return new User(id,  "默认用户Factory", "默认密码Fac", "默认昵称Fac");
            }
        };
    }

}



